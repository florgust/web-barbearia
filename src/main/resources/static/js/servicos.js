// Função para abrir o modal
function openModal() {
    document.getElementById("criarServicoModal").classList.remove("hidden");
}

// Função para fechar o modal
function closeModal() {
    document.getElementById("criarServicoModal").classList.add("hidden");
}

// Função de edição de serviço
function editServico(id) {
    // Aqui você pode carregar os dados do serviço para o modal de edição
    alert("Editando serviço com ID: " + id);
}

// Função de deletação de serviço
function deleteServico(id) {
    if (confirm("Você tem certeza que deseja deletar este serviço?")) {
        // Aqui você pode chamar a operação de deleção no backend
        alert("Deletando serviço com ID: " + id);
    }
}

// Submit do formulário de criação
document.getElementById('formCriarServico').addEventListener('submit', function (event) {
    event.preventDefault();
    // Aqui você pode enviar os dados do formulário para o backend
    alert('Serviço criado!');
    closeModal();
});