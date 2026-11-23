package todo.grails

import grails.gorm.transactions.Transactional
import org.springframework.transaction.interceptor.TransactionAspectSupport


class TarefaController {

    def index() {
        respond Tarefa.list()
    }

    @Transactional
    def save(Tarefa tarefa) {
        if (tarefa.validate()) {
            tarefa.save(flush: true)
            respond tarefa, status: 201
        } else {
            respond tarefa.errors, status: 422
        }
    }

    def show(Long id) {
        def tarefa = Tarefa.get(id)

        if (tarefa) {
            respond tarefa, status: 200
        } else {
            render status: 404
        }
    }

    @Transactional
    def update(Long id) {
        def tarefa = Tarefa.get(id)

        if (tarefa) {
            tarefa.properties = request.JSON

            if (tarefa.validate()) {
                tarefa.save(flush: true)
                respond tarefa, status: 200
            } else {
                tarefa.discard()
                respond tarefa.errors, status: 422
            }
        } else {
            render status: 404
        }
    }

    @Transactional
    def delete(Long id) {
        def tarefa = Tarefa.get(id)
        if (tarefa) {
            tarefa.delete(flush: true)
            render status: 204
        } else {
            render status: 404
        }
    }
}