import UIKit
import SharedCode

class ViewController: UIViewController, View {
   
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        
        let presenter = RecipePresenter()
        presenter.view = self
        
        presenter.start()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func showState(json: String) {
        label.text = json
        view.addSubview(label)
    }
    
    @IBOutlet weak var label: UILabel!
}
