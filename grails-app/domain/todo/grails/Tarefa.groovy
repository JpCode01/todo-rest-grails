package todo.grails

import todo.grails.enums.Prioridade
import todo.grails.enums.Status

class Tarefa {

    String titulo
    String descricao

    Prioridade prioridade = Prioridade.MEDIA
    Status status = Status.PENDENTE

    static mapping = {
        prioridade enumType: 'string'
        status enumType: 'string'
    }

    static constraints = {
        titulo blank: false, nullable: false, size: 3..80
        descricao nullable: true, maxSize: 500
        prioridade nullable: false
        status nullable: false
    }
}