package todo.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TarefaSpec extends Specification implements DomainUnitTest<Tarefa> {

     void "test domain constraints"() {
        when:
        Tarefa domain = new Tarefa()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
