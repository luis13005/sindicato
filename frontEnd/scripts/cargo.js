const baseURL = 'http://localhost:8081/cargo';

// Capturar o evento de envio do formulário
const form = document.getElementById('form-cargo');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const cargoDescricao = document.getElementById('descricao').value;
    const cargoCodigo = document.getElementById('codigo').value;


    console.log(descricao, nivel, classe, padrao);
    if (!cargoDescricao || !cargoCodigo ) {
        alert('Preencha todos os campos!');
        return;
    }

    const data = {
        cargoCodigo: cargoCodigo,
        cargoDescricao: cargoDescricao
    };

    try {
        const response = await fetch(`${baseURL}/cargo`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Cargo cadastrado com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar o cargo:', await response.text());
            alert('Erro ao cadastrar o cargo.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});

// Carregar os estados ao carregar a página
document.addEventListener('DOMContentLoaded', carregarNiveis);
document.addEventListener('DOMContentLoaded',carregarClasses);