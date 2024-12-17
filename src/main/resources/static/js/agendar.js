// Renderiza os dados de horariosOcupados do Thymeleaf para o JS
const horariosOcupados = /*[[${horariosOcupados}]]*/ {};

// Variável para armazenar o horário selecionado
let horarioSelecionado = null;
let diaSelecionado = null;

// Função para criar slots de horário
function criarHorarios(dia, slotsId, data) {
    const horarios = ['08:00', '09:00', '10:00', '11:00', '14:00', '15:00', '16:00', '17:00', '18:00'];
    const slotsContainer = document.getElementById(slotsId);
    slotsContainer.innerHTML = '';

    horarios.forEach((hora) => {
        const ocupado = horariosOcupados[data]?.includes(hora);

        const slot = document.createElement('button');
        slot.textContent = hora;
        slot.className = `w-full py-2 text-center rounded ${ocupado ? 'bg-red-500 text-white cursor-not-allowed' : 'bg-green-500 text-white hover:bg-green-400'
            } calendar-slot`;
        slot.disabled = ocupado;

        // Adiciona evento de clique para selecionar o horário
        slot.addEventListener('click', () => {
            if (horarioSelecionado) {
                horarioSelecionado.classList.remove('bg-blue-500');
                horarioSelecionado.classList.add('bg-green-500');
            }
            slot.classList.remove('bg-green-500');
            slot.classList.add('bg-blue-500');
            horarioSelecionado = slot;
            diaSelecionado = data;

            // Atualiza os campos ocultos do formulário
            document.getElementById('selected-date').value = diaSelecionado;
            document.getElementById('selected-time').value = horarioSelecionado.textContent;

            // Habilita o botão "Agendar"
            document.getElementById('btn-agendar').disabled = false;
        });

        slotsContainer.appendChild(slot);
    });
}

// Função para formatar a data no formato dd/MM/yyyy
function formatarData(data) {
    const dia = String(data.getDate()).padStart(2, '0');
    const mes = String(data.getMonth() + 1).padStart(2, '0');
    const ano = data.getFullYear();
    return `${dia}/${mes}/${ano}`;
}

// Função para atualizar a semana dinamicamente
function atualizarSemana(dataBase) {
    const dias = [];
    const ids = ['monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday'];

    // Gerar as datas para a semana (de segunda a sábado)
    for (let i = 0; i < 6; i++) {
        const diaSemana = new Date(dataBase);
        diaSemana.setDate(dataBase.getDate() + i); // Adiciona i dias
        dias.push(diaSemana);
    }

    // Atualizar os cards com as datas
    dias.forEach((data, index) => {
        const diaFormatado = formatarData(data);
        document.getElementById(ids[index] + '-date').textContent = diaFormatado;
        criarHorarios(diaFormatado, ids[index] + '-slots', diaFormatado);
    });
}

// Função para alterar a semana ao clicar nos botões
let dataBase = new Date(); // Data base inicial (primeiro dia da semana)
document.getElementById('prev-week').addEventListener('click', () => {
    dataBase.setDate(dataBase.getDate() - 7);
    atualizarSemana(dataBase);
});
document.getElementById('next-week').addEventListener('click', () => {
    dataBase.setDate(dataBase.getDate() + 7);
    atualizarSemana(dataBase);
});

// Inicializar ao carregar a página
document.addEventListener('DOMContentLoaded', () => {
    atualizarSemana(dataBase);
});