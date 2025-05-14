const baseURL = 'http://localhost:8081';

// Capturar o evento de envio do formulário
const form = document.getElementById('form-lotacao');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const descricao = document.getElementById('descricao').value;

    if (!descricao) {
        alert('Preencha o campo de descrição!');
        return;
    }

    const data = {
        lotacaoDescricao: descricao
    };

    try {
        const response = await fetch(`${baseURL}/lotacao`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Lotação cadastrada com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar a lotação:', await response.text());
            alert('Erro ao cadastrar a lotação.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});