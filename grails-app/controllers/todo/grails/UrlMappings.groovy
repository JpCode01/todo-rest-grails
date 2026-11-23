package todo.grails

class UrlMappings {
    static mappings = {
        get "/tarefas"(controller: "tarefa", action: "index")
        post "/tarefas"(controller: "tarefa", action: "save")
        get "/tarefas/$id"(controller: "tarefa", action: "show")
        put "/tarefas/$id"(controller: "tarefa", action: "update")
        delete "/tarefas/$id"(controller: "tarefa", action: "delete")
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        "/"(controller: 'application', action:'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
