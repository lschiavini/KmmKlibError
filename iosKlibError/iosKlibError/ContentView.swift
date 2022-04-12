//
//  ContentView.swift
//  iosKlibError
//
//  Created by Mac on 23/03/22.
//

import SwiftUI
import shared_core

@available(iOS 13.0.0, *)
struct ContentView: View {
    

    
    var body: some View {
        VStack {
            Text("Hello, world!").padding()
            Button(action: runAsync) { Text("Run Async") }
            Button(action: runSync) { Text("Run Sync") }
        }
    }
    
   
    func runAsync() {
        RunTest.shared.runAsync()
    }
    
    
    func runSync() {
       RunTest.shared.runSync()
    }
}

@available(iOS 13.0.0, *)
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
