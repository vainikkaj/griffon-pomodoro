package pomodoro

import groovy.ui.Console
import static java.awt.TrayIcon.MessageType.*

application(title: 'pomodoro',
  preferredSize: [320, 240],
  pack: true,
  //location: [50,50],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    // add content here
    label('Content Goes Here') // delete me
}

actions {
   action(id: 'cutAction',
      name: 'Cut',
      closure: { trayIcon.displayMessage("Cut","Cut some content",NONE)},
      mnemonic: 'T',
      accelerator: shortcut('X'),
      smallIcon: imageIcon(resource:"/griffon-icon-16x16.png", class: Console),
      shortDescription: 'Cut'
   )
   action(id: 'copyAction',
      name: 'Copy',
      closure: { trayIcon.displayMessage("Copy","Copy some content",INFO)},
      mnemonic: 'C',
      accelerator: shortcut('C'),
      smallIcon: imageIcon(resource:"/griffon-icon-16x16.png", class: Console),
      shortDescription: 'Copy'
   )
   action(id: 'pasteAction',
      name: 'Paste',
      closure: { trayIcon.displayMessage("Paste","Paste some content",WARNING)},
      mnemonic: 'P',
      accelerator: shortcut('V'),
      smallIcon: imageIcon(resource:"/griffon-icon-16x16.png", class: Console),
      shortDescription: 'Paste'
   )
   action( id: 'exitAction',
      name: 'Quit',
      closure: { trayIcon.displayMessage("Quit","No can do!",ERROR)},
      mnemonic: 'Q',
      accelerator: shortcut('Q'),
      shortDescription: 'Quit'
   )
}

systemTray {
  trayIcon(id: "trayIcon",
    resource: "/griffon-icon-16x16.png",
    class: groovy.ui.Console,
    toolTip: "Double click on me and I'll go away!",
    actionPerformed: {systemTray.remove(trayIcon)}) {
    popupMenu {
       menuItem(cutAction)
       menuItem(copyAction)
       menuItem(pasteAction)
       separator()
       menuItem(exitAction)
    }
  }
}