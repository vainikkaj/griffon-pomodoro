application {
    title = 'Pomodoro'
    startupGroups = ['pomodoro']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "pomodoro"
    'pomodoro' {
        model      = 'pomodoro.PomodoroModel'
        view       = 'pomodoro.PomodoroView'
        controller = 'pomodoro.PomodoroController'
    }

}
