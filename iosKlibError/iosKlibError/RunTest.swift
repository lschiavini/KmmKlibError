//
//  RunTest.swift
//  iosKlibError
//
//  Created by Luiz Henrique De Barros De Oliveir on 08/04/22.
//

import Foundation
import shared_core


class RunTest {
    
    static var shared: RunTest  = RunTest()
    
    var asynchronous: TestAsynchronousAccess = TestAsynchronousAccess()

    
    
    ///
    /// - Funciona:
    ///        Instanciar dentro da proprio acesso concorrente
    ///        Chamada na thread principal
    ///        Ao adicionar as propriedades no Gradle, é possível acessar com outras threads
    ///             kotlin.native.binary.memoryModel=experimental
    ///             kotlin.native.binary.freezing=disabled
    ///
    ///
    ///
    /// - Não funciona:
    ///        Chamar o atributo em mais de uma thread
    ///        Chamar fora da thread principal
    ///
    ///

    func runAsync() {
        print("Running...")
        DispatchQueue.main.async {
            StatelyExample().doStuff()
            self.asynchronous.insertValue()
            print("Finish main")
        }
        
        serialQueue_01.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 01")
        }

        
        
        serialQueue_02.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 02")
        }

        serialQueue_03.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 03")
        }

        serialQueue_04.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 04")
        }

        serialQueue_05.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 05")
        }

        serialQueue_06.async {
            StatelyExample().doStuff()
//            StatelyExample.companion.doStuff()
            self.asynchronous.insertValue()
            print("Finish 06")
        }
        
    }
    func runSync()  {
        print("Running...")
        self.asynchronous.insertValue()
        print("Finish")
    }
    
}
