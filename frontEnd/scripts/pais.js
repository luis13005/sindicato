const baseURL = 'http://localhost:8081';

const form = document.getElementById('form-pais');

form.addEventListener('submit', async (event) => {

    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const sigla = document.getElementById('sigla').value;

    if (nome == null || sigla == null || nome === "" || sigla === "") {
        alert("Preencha todos os campos!");
        return;
    } else {
        const data = {
            nome: nome,
            sigla: sigla
        };
        console.log('Dados a serem enviados:', data); // Log dos dados a serem enviados
        try {
            const response = await fetch(`${baseURL}/pais/pais`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                const resultado = await response.json();
                console.log('Resposta do backend:', resultado);
                alert('País cadastrado com sucesso!');
                form.reset();
            } else {
                const erro = await response.text();
                console.error('Erro do backend:', erro);
                alert('Erro ao cadastrar o país.');
            }
        } catch (error) {
            console.error('Erro ao conectar ao servidor:', error);
            alert('Erro ao conectar ao servidor.');
        }
    }
});
