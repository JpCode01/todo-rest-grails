package todo.grails

import todo.grails.enums.Prioridade

class Tarefa {

    String titulo
    String descricao
    Prioridade prioridade

    static mapping = {
        prioridade enumType: 'string'
    }

    static constraints = {
    }
}