package todo.grails

import grails.gorm.transactions.Transactional

@Transactional
class TarefaService {

    def listar() {
        Tarefa.list()
    }

    def buscar(Long id) {
        Tarefa.get(id)
    }

    def criar(Tarefa tarefa) {
        if (!tarefa.validate()) {
            return tarefa
        }

        tarefa.save(flush: true)
        return tarefa
    }

    def atualizar(Long id, Map dados) {
        def tarefa = Tarefa.get(id)

        if (!tarefa) {
            return null
        }

        tarefa.properties = dados

        if (!tarefa.validate()) {
            def erros = tarefa.errors
            tarefa.discard()
            return [tarefa: null, errors: erros]
        }

        tarefa.save(flush: true)
        return [tarefa: tarefa, errors: null]
    }

    def excluir(Long id) {
        def tarefa = Tarefa.get(id)

        if (!tarefa) {
            return false
        }

        tarefa.delete(flush: true)
        return true
    }
}