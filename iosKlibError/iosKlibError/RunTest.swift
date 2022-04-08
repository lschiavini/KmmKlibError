//
//  RunTest.swift
//  iosKlibError
//
//  Created by Luiz Henrique De Barros De Oliveir on 08/04/22.
//

import Foundation

class RunTest {
    
    static var shared: RunTest  = RunTest()
    
    var asynchronous: TestAsynchronousAccess = TestAsynchronousAccess(qtd: Int32(1000000))

    func runAsync() {
        print("Running...")
        DispatchQueue.main.async {
            self.asynchronous.insertValue()
        }
        
        serialQueue_01.async {
            self.asynchronous.insertValue()
        }
        
        serialQueue_02.async {
            self.asynchronous.insertValue()
        }
        
        serialQueue_03.async {
            self.asynchronous.insertValue()
        }

    }
    
    func runSync() {
        print("Running...")
        self.asynchronous.insertValue()
        print("Finish")
    }
    
    
}
