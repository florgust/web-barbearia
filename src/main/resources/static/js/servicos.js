// Função de edição de serviço
function editServico(id) {
    // Aqui você pode carregar os dados do serviço para o modal de edição
    alert("Editando serviço com ID: " + id);
}

// Função de deletação de serviço
function deleteServico(id) {
    if (confirm("Você tem certeza que deseja deletar este serviço?")) {
        // Cria um formulário temporário para enviar a requisição POST
        var form = document.createElement("form");
        form.method = "POST";
        form.action = "/servicos/remover";

        // Adiciona um campo hidden com o ID do serviço
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "id";
        input.value = id;
        form.appendChild(input);

        // Adiciona o formulário ao corpo e o envia
        document.body.appendChild(form);
        form.submit();

        // Exibe um alerta de confirmação
        alert("Serviço deletado com sucesso!");
    }
}

// Submit do formulário de criação
document.getElementById('formCriarServico').addEventListener('submit', function (event) {
    event.preventDefault();
    // Aqui você pode enviar os dados do formulário para o backend
    alert('Serviço criado!');
    closeModal();
});