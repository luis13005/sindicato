const baseURL = 'http://localhost:8081';

// Preencher a combo box com os países
async function carregarPaises() {
    try {
        const response = await fetch(`${baseURL}/estado/buscapaises`);
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

// Capturar o evento de envio do formulário
const form = document.getElementById('form-estado');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const sigla = document.getElementById('sigla').value;
    const paisSelect = document.getElementById('pais');
    const paisId = paisSelect.options[paisSelect.selectedIndex].value; // Obter o ID do país selecionado
    console.log('Dados a serem enviados:', { nome, sigla, paisId }); // Log dos dados a serem enviados

    if (!nome || !sigla || !paisId) {
        alert('Preencha todos os campos!');
        return;
    }

    const data = {
        nome: nome,
        sigla: sigla,
        paisId: paisId
    };

    try {
        const response = await fetch(`${baseURL}/estado/estado`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Estado cadastrado com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar o estado:', await response.text());
            alert('Erro ao cadastrar o estado.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});

// Carregar os países ao carregar a página
document.addEventListener('DOMContentLoaded', carregarPaises);