package todo.grails

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class TarefaControllerSpec extends Specification implements ControllerUnitTest<TarefaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
