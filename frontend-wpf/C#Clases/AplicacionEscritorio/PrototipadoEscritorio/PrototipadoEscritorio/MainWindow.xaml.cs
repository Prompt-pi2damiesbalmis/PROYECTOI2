using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace PrototipadoEscritorio
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        private bool opcionesAbierto = false;

        private void BtnOpciones_Click(object sender, RoutedEventArgs e)
        {
            double targetHeight = opcionesAbierto ? 0 : 180; // Ajusta según el contenido
            opcionesAbierto = !opcionesAbierto;

            var anim = new DoubleAnimation
            {
                To = targetHeight,
                Duration = TimeSpan.FromMilliseconds(300),
                AccelerationRatio = 0.2,
                DecelerationRatio = 0.8
            };

            PanelOpcionesContainer.BeginAnimation(HeightProperty, anim);
        }
    }
}