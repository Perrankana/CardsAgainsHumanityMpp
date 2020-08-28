//
//  ContentView.swift
//  iosApp
//
//  Created by Perrankana on 28/08/2020.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject public var viewModel: ContentViewModel
    
    var body: some View {
        Text(viewModel.text)
    }
}

final class ContentViewModel: ObservableObject {
    @Published private(set) var text: String = "Holi"
    func setText(newText: String){
        text = newText
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: ContentViewModel())
    }
}
