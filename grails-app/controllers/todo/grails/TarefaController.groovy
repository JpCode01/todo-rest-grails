package todo.grails

import grails.gorm.transactions.Transactional
import org.springframework.transaction.interceptor.TransactionAspectSupport


class TarefaController {

    TarefaService tarefaService

    def index() {
        respond tarefaService.listar()
    }

    def save(Tarefa tarefa) {
        def resultado = tarefaService.criar(tarefa)

        if (resultado.hasErrors()) {
            respond resultado.errors, status: 422
        } else {
            respond resultado, status: 201
        }
    }

    def show(Long id) {
        def tarefa = tarefaService.buscar(id)

        if (tarefa) {
            respond tarefa, status: 200
        } else {
            render status: 404
        }
    }

    def update(Long id) {
        def resultado = tarefaService.atualizar(
                id, request.JSON as Map
        )

        if (!resultado) {
            render status: 404
        } else if (resultado.errors) {
            respond resultado.errors, status: 422
        } else {
            respond resultado.tarefa, status: 200
        }
    }

    def delete(Long id) {
        if (tarefaService.excluir(id)) {
            render status: 204
        } else {
            render status: 404
        }
    }
}