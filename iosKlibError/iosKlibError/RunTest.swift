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
            print("Finish main")
        }
        
        serialQueue_01.async {
            self.asynchronous.insertValue()
            print("Finish 01")
        }
        
        serialQueue_02.async {
            self.asynchronous.insertValue()
            print("Finish 02")
        }
        
        serialQueue_03.async {
            self.asynchronous.insertValue()
            print("Finish 03")
        }
        
        serialQueue_04.async {
            self.asynchronous.insertValue()
            print("Finish 04")
        }
        
        serialQueue_05.async {
            self.asynchronous.insertValue()
            print("Finish 05")
        }
        
        serialQueue_06.async {
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
