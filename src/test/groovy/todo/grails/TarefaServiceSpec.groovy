package todo.grails

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class TarefaServiceSpec extends Specification implements ServiceUnitTest<TarefaService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
