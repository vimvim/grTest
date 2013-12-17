
/**
 * Created with IntelliJ IDEA.
 * User: vim
 * Date: 12/17/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */

class Repository {

    def open(String name) {
        println("Repository open")
    }
}

class MemoDsl {

    static Repository repository = new Repository()

    String toText
    String fromText
    String body

    def sections = []

    /**
     * This method accepts a closure which is essentially the DSL. Delegate the
     * closure methods to
     * the DSL class so the calls can be processed
     */
    def static make(closure) {
        MemoDsl memoDsl = new MemoDsl()
        // any method called in closure will be delegated to the memoDsl class
        closure.delegate = memoDsl
        closure()
    }

    /**
     * Store the parameter as a variable and use it later to output a memo
     */
    def to(String toText) {
        this.toText = toText
    }

    def from(String fromText) {
        this.fromText = fromText
    }

    def body(String bodyText) {
        this.body = bodyText
    }

    static def repository() {
        println("Goto repository submodule")
    }
}

MemoDsl.make {
    to "Nirav Assar"
    from "Barack Obama"
    body "How are things? We are doing well. Take care"
}

MemoDsl.make { to "Nirav Assar" }

MemoDsl.repository.open "test"

MemoDsl.repository()
