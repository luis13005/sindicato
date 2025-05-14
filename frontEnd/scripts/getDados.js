const baseURL = 'http://localhost:8080';

export default function getDados(endpoint) {
    return fetch(`${baseURL}${endpoint}`)
    .then((response) => response.json())
    .catch((error) => {
        console.error('Erro ao acessar a url:'+baseURL+endpoint, error);
        throw error; // Re-throw the error for further handling if needed
    });
}
