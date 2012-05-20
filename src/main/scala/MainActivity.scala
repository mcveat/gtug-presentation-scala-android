package gtug.samples

import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Toast
import Helper._
import android.content.Intent
import android.view.{Menu, View}

object Helper {
  implicit def function2OnClickListener(f: View => Unit) = new OnClickListener {
    def onClick(v: View) { f(v) }
  }
}

class MainActivity extends Activity with TypedActivity with CommonMenu {
  lazy val nice_button = findView(TR.nice_button)

  def toast(s: String) {
    Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show()
  }

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    nice_button.setOnClickListener { v :View =>
      toast("Hello GTUG")
      val i = new Intent(MainActivity.this, classOf[HelloActivity])
      startActivity(i)
    }
  }
}

class HelloActivity extends Activity with CommonMenu {
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.next)
  }
}


trait CommonMenu extends Activity {
  override def onCreateOptionsMenu(menu: Menu) = {
    menu.addSubMenu("About...")
    true
  }
}

