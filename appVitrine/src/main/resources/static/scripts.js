document.addEventListener('DOMContentLoaded', function() {
    loadVitrines();

    document.getElementById('create-form').addEventListener('submit', function(event) {
        event.preventDefault();

        // Obter dados do formulário
        let dataInicio = document.getElementById('dataInicio').value;
        let dataFim = document.getElementById('dataFim').value;

        // Construir objeto para enviar para API
        let vitrineData = {
            dataInicio: dataInicio,
            dataFim: dataFim
        };

        // Enviar dados para API via POST
        fetch('/vitrines', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(vitrineData)
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Erro ao criar vitrine');
            }
        })
        .then(data => {
            console.log('Vitrine criada:', data);
            loadVitrines(); // Atualizar lista de vitrines após criação
            document.getElementById('create-form').reset(); // Limpar formulário
        })
        .catch(error => {
            console.error('Erro ao criar vitrine:', error);
        });
    });

    function loadVitrines() {
        // Limpar lista de vitrines existente
        document.getElementById('vitrines-list').innerHTML = '';

        // Buscar vitrines da API via GET
        fetch('/vitrines')
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Erro ao carregar vitrines');
            }
        })
        .then(data => {
            data.forEach(vitrine => {
                // Criar elemento de vitrine e adicionar à lista
                let vitrineElement = document.createElement('li');
                vitrineElement.textContent = `Data de Início: ${vitrine.dataInicio}, Data de Fim: ${vitrine.dataFim}`;

                // Botão para excluir vitrine
                let deleteButton = document.createElement('button');
                deleteButton.textContent = 'Excluir';
                deleteButton.classList.add('delete-btn');
                deleteButton.onclick = function() {
                    excluirVitrine(vitrine.id);
                };

                // Adicionar botão de excluir à vitrine
                vitrineElement.appendChild(deleteButton);

                // Adicionar vitrine à lista
                document.getElementById('vitrines-list').appendChild(vitrineElement);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar vitrines:', error);
        });
    }

    function excluirVitrine(id) {
        fetch(`/vitrines/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                console.log(`Vitrine com ID ${id} deletada com sucesso.`);
                loadVitrines(); // Recarrega a lista de vitrines
            } else {
                console.error(`Erro ao tentar deletar vitrine com ID ${id}.`);
            }
        })
        .catch(error => console.error('Erro ao deletar vitrine:', error));
    }
});
