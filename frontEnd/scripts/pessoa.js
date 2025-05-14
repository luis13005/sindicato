const baseURL = 'http://localhost:8081/pessoa';

async function carregarNiveis() {
    try {
        const response = await fetch(`${baseURL}/buscaniveis`);
        
        if (response.ok) {
            const niveis = await response.json();
            const selectNivel = document.getElementById('nivel');

            niveis.forEach(nivel => {
                const option = document.createElement('option');
                option.value = nivel.nivel; // Supondo que o backend retorna um ID para cada nível
                option.textContent = 'Nível '+nivel.nivel; // Supondo que o backend retorna um nome para cada nível
                selectNivel.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar os níveis:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

async function carregarClasses(){
    try{
        const response = await fetch(`${baseURL}/buscaclasses`);

        if (response.ok) {
            const classes = await response.json();
            const selectClasse = document.getElementById('classe');

            classes.forEach(classe => {
                const option = document.createElement('option');
                option.value = classe.classe; // Supondo que o backend retorna um ID para cada classe
                option.textContent = classe.classe;
                selectClasse.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar as classes:', await response.text());
        }
    }catch(error){
        console.error('Erro ao conectar ao servidor:', error);
    }
}

// Função para carregar os países
async function carregarPaises() {
    try {
        const response = await fetch(`${baseURL}/pais`);
        if (response.ok) {
            const paises = await response.json();
            const selectPais = document.getElementById('pais');
            paises.forEach(pais => {
                const option = document.createElement('option');
                option.value = pais.paisId; // Supondo que o backend retorna um ID para cada país
                option.textContent = pais.nome;
                selectPais.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar os países:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

// Função para carregar os estados com base no país selecionado
async function carregarEstados(paisId) {
    try {
        const response = await fetch(`${baseURL}/estado/${paisId}`);
        if (response.ok) {
            const estados = await response.json();
            const selectEstado = document.getElementById('estado');
            selectEstado.innerHTML = '<option value="">Selecione um estado</option>'; // Limpa opções anteriores
            estados.forEach(estado => {
                const option = document.createElement('option');
                option.value = estado.estadoId;
                option.textContent = estado.estadoNome;
                selectEstado.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar os estados:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

// Função para carregar as cidades com base no estado selecionado
async function carregarCidades(estadoId) {
    try {
        const response = await fetch(`${baseURL}/cidade/${estadoId}`);
        if (response.ok) {
            const cidades = await response.json();
            const selectCidade = document.getElementById('cidadeAtual');
            selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>'; // Limpa opções anteriores
            cidades.forEach(cidade => {
                const option = document.createElement('option');
                option.value = cidade.cidadeId;
                option.textContent = cidade.cidadeNome;
                selectCidade.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar as cidades:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

// Capturar o evento de mudança do combo box de País
document.getElementById('pais').addEventListener('change', (event) => {
    const paisId = event.target.value;

    const selectEstado = document.getElementById('estado');
    selectEstado.innerHTML = '<option value="">Selecione um estado</option>';

    const selectCidade = document.getElementById('cidadeAtual');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';

    carregarEstados(paisId);
});

// Capturar o evento de mudança do combo box de Estado
document.getElementById('estado').addEventListener('change', (event) => {
    const estadoId = event.target.value;

    const selectCidade = document.getElementById('cidadeAtual');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';
    carregarCidades(estadoId);
});

// Capturar o evento de envio do formulário
const form = document.getElementById('form-pessoa');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const data = {
        nomeCompleto: document.getElementById('nomeCompleto').value,
        rg: document.getElementById('rg').value,
        orgaoExpedidor: document.getElementById('orgaoExpedidor').value,
        dataEmissaoRg: document.getElementById('dataEmissaoRg').value,
        cep: document.getElementById('cep').value,
        endereco: document.getElementById('endereco').value,
        bairro: document.getElementById('bairro').value,
        pais: document.getElementById('pais').value,
        estado: document.getElementById('estado').value,
        cidadeAtual: document.getElementById('cidadeAtual').value,
        paisNatural: document.getElementById('paisNatural').value,
        estadoNatural: document.getElementById('estadoNatural').value,
        cidadeNatural: document.getElementById('cidadeNatural').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value,
        celular: document.getElementById('celular').value,
        watsapp: document.getElementById('watsapp').value,
        formacaoId: document.getElementById('formacaoId').value,
        dataNascimento: document.getElementById('dataNascimento').value,
        sexo: document.getElementById('sexo').value,
        estadoCivil: document.getElementById('estadoCivil').value,
        nomeMae: document.getElementById('nomeMae').value,
        nomePai: document.getElementById('nomePai').value,
        lotacao: document.getElementById('lotacao').value
    };

    try {
        const response = await fetch(`${baseURL}/pessoa`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Pessoa cadastrada com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar a pessoa:', await response.text());
            alert('Erro ao cadastrar a pessoa.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});

document.addEventListener('DOMContentLoaded', carregarPaises);
document.addEventListener('DOMContentLoaded', carregarEstados);
document.addEventListener('DOMContentLoaded', carregarCidades);