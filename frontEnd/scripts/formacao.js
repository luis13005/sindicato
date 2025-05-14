const baseURL = 'http://localhost:8081';

// Capturar o evento de envio do formulário
const form = document.getElementById('form-formacao');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const codigo = document.getElementById('codigo').value;
    const nome = document.getElementById('nome').value;

    if (!codigo || !nome) {
        alert('Preencha todos os campos!');
        return;
    }

    const data = {
        codigoFormacao: codigo,
        nomeFormacao: nome
    };

    try {
        const response = await fetch(`${baseURL}/formacao/formacao`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Formação cadastrada com sucesso!');
            form.reset();
        } else {
            console.error('Erro ao cadastrar a formação:', await response.text());
            alert('Erro ao cadastrar a formação.');
        }
    } catch (error) {
        console.error('Erro ao conectar ao servidor:', error);
        alert('Erro ao conectar ao servidor.');
    }
});