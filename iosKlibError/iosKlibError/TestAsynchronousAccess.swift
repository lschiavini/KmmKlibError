//
//  TestAsynchronousAccess.swift
//  iosKlibError
//
//  Created by Luiz Henrique De Barros De Oliveir on 08/04/22.
//

import Foundation

import shared_core

class TestAsynchronousAccess: AsynchronousAccess {
    
    let sizeArray: Int32
    
    init(qtd: Int32) {
        self.sizeArray = qtd
        super.init(size: qtd)
    }
    
    func insertValue() {
        var i: Int32 = 1
        while i < sizeArray {
            self.setData(value: i - Int32(1))
            i = i + Int32(1)
        }
    }
}

