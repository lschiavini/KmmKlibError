//
//  TestAsynchronousAccess.swift
//  iosKlibError
//
//  Created by Luiz Henrique De Barros De Oliveir on 08/04/22.
//

import Foundation

import shared_core

//class TestAsynchronousAccess: AsynchronousAccess {
//    var freeze: AsynchronousAccess? = nil
//    let sizeArray: Int32
//
//    init(qtd: Int32) {
//        self.sizeArray = qtd
//        super.init(size: qtd)
//        self.freeze = self.toFreeze()
//
//    }
//
//    func insertValue() {
//        var i: Int32 = 1
//        while i < sizeArray {
//            // acesso de leitura
//            if let fr = freeze {
//                fr.getData()
//            }
//            i = i + Int32(1)
//        }
//    }
//}


class TestAsynchronousAccess: AsynchronousAccessStately {
//    var freeze: AsynchronousAccess? = nil
    let sizeArray: Int32

    init(qtd: Int32) {
        self.sizeArray = qtd
        super.init()
//        self.freeze = self.toFreeze()

    }

    func insertValue() {
        var i: Int32 = 1
        while i < sizeArray {
            self.setData(position: i)
//            if let fr = freeze {

//            }
            i = i + Int32(1)
        }
//        print(self.getData())
    }
}



