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
            const selectPaisNatural = document.getElementById('paisNatural');
            paises.forEach(pais => {
                const option = document.createElement('option');
                option.value = pais.paisId; 
                option.textContent = pais.nome;
                selectPais.appendChild(option);
                selectPaisNatural.appendChild(option.cloneNode(true));
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
         console.log('Carregando estados para o país:'+ paisId);
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


document.getElementById('pais').addEventListener('change', (event) => {
    const paisId = event.target.value;

    const selectEstado = document.getElementById('estado');
    selectEstado.innerHTML = '<option value="">Selecione um estado</option>';

    const selectCidade = document.getElementById('cidadeAtual');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';

    carregarEstados(paisId);
});


document.getElementById('estado').addEventListener('change', (event) => {
    const estadoId = event.target.value;

    const selectCidade = document.getElementById('cidadeAtual');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';
    carregarCidades(estadoId);
});

// Função para carregar os estados com base no país selecionado
async function carregarEstadosNaturais(paisId) {
    try {
        const response = await fetch(`${baseURL}/estado/${paisId}`);
        if (response.ok) {
            const estados = await response.json();
            const selectEstadoNatural = document.getElementById('estadoNatural');
            selectEstadoNatural.innerHTML = '<option value="">Selecione um estado</option>'; // Limpa opções anteriores
            estados.forEach(estado => {
                const option = document.createElement('option');
                option.value = estado.estadoId;
                option.textContent = estado.estadoNome;
                selectEstadoNatural.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar os estados:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

async function carregarCidadesNaturais(estadoId) {
    try {
        const response = await fetch(`${baseURL}/cidade/${estadoId}`);
        if (response.ok) {
            const cidades = await response.json();
            const selectCidadeNatural = document.getElementById('cidadeNatural');
            selectCidadeNatural.innerHTML = '<option value="">Selecione uma cidade</option>'; // Limpa opções anteriores
            cidades.forEach(cidade => {
                const option = document.createElement('option');
                option.value = cidade.cidadeId;
                option.textContent = cidade.cidadeNome;
                selectCidadeNatural.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar as cidades:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

document.getElementById('paisNatural').addEventListener('change', (event) => {
    const paisId = event.target.value;

    const selectEstado = document.getElementById('estadoNatural');
    selectEstado.innerHTML = '<option value="">Selecione um estado</option>';

    const selectCidade = document.getElementById('cidadeNatural');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';

    carregarEstadosNaturais(paisId);
});

document.getElementById('estadoNatural').addEventListener('change', (event) => {
    const estadoId = event.target.value;

    const selectCidade = document.getElementById('cidadeNatural');
    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';
    carregarCidadesNaturais(estadoId);
});

async function carregarEstadoCivil() {
    try {
        const response = await fetch(`${baseURL}/estadocivil`);
        if (response.ok) {
            const estadosCivis = await response.json();
            const selectEstadoCivil = document.getElementById('estadoCivil');
            estadosCivis.forEach(estadoCivil => {
                const option = document.createElement('option');
                option.value = estadoCivil.estadoCivil; // Supondo que o backend retorna um ID
                option.textContent = estadoCivil.estadoCivil; // Supondo que o backend retorna um nome
                selectEstadoCivil.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar os estados civis:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

async function carregarFormacoes() {
    try{
        const response = await fetch(`${baseURL}/formacao`);
        if (response.ok) {
            const formacoes = await response.json();
            const selectFormacao = document.getElementById('formacaoId');
            formacoes.forEach(formacao => {
                const option = document.createElement('option');
                option.value = formacao.formacaoCodigo; // Supondo que o backend retorna um ID
                option.textContent = formacao.formacaoCodigo+'-'+formacao.nomeFormacao; // Supondo que o backend retorna um nome
                selectFormacao.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar as formações:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

async function carregarLotacoes(){
    try{
        const response = await fetch(`${baseURL}/lotacao`);
        if (response.ok) {
            const lotacoes = await response.json();
            const selectLotacao = document.getElementById('lotacao');
            lotacoes.forEach(lotacao => {
                const option = document.createElement('option');
                option.value = lotacao.lotacaoId; // Supondo que o backend retorna um ID
                option.textContent = lotacao.lotacaoDescricao; // Supondo que o backend retorna um nome
                selectLotacao.appendChild(option);
            });
        } else {
            console.error('Erro ao carregar as lotações:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
    }
}

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
document.addEventListener('DOMContentLoaded', carregarNiveis);
document.addEventListener('DOMContentLoaded', carregarClasses);
document.addEventListener('DOMContentLoaded', carregarEstadoCivil);
document.addEventListener('DOMContentLoaded', carregarFormacoes);
document.addEventListener('DOMContentLoaded', carregarLotacoes);