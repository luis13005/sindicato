const baseURL = 'http://localhost:8081';

// Preencher a combo box com os estados
async function carregarEstados() {
    try {
        const response = await fetch(`${baseURL}/cidade/buscaestados`);
        if (response.ok) {
            const estados = await response.json();
            const selectEstado = document.getElementById('estado');
            estados.forEach(estado => {
                const option = document.createElement('option');
                option.value = estado.estadoId; // Supondo que o backend retorna um ID para cada estado
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

// Capturar o evento de envio do formulário
const form = document.getElementById('form-cidade');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const cidadeNome = document.getElementById('nome').value;
    const estadoSelect = document.getElementById('estado');
    const estadoId = estadoSelect.value; // Obter o ID do estado selecionado

    if (!nome || !estadoId) {
        alert('Preencha todos os campos!');
        return;
    }

    const data = {
        cidadeNome: cidadeNome,
        estadoId: estadoId
    };

    try {
        const response = await fetch(`${baseURL}/cidade/cidade`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Cidade cadastrada com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar a cidade:', await response.text());
            alert('Erro ao cadastrar a cidade.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});

// Carregar os estados ao carregar a página
document.addEventListener('DOMContentLoaded', carregarEstados);