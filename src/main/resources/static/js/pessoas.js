function deletePessoa(id) {
    if (confirm("Você tem certeza que deseja deletar esta pessoa?")) {
        // Cria um formulário temporário para enviar a requisição POST
        var form = document.createElement("form");
        form.method = "POST";
        form.action = "/pessoas/remover";

        // Adiciona um campo hidden com o ID da pessoa
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "codigo";
        input.value = id;
        form.appendChild(input);

        // Adiciona o formulário ao corpo e o envia
        document.body.appendChild(form);
        form.submit();
    }
}