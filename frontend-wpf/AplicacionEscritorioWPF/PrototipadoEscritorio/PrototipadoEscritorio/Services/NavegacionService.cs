using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace PrototipadoEscritorio.Services
{
    internal class NavegacionService
    {
        private static UserControl listadoPersonasVista, NuevaPersonaUserControl, consultaPersonaUserControl;

        //public UserControl ObtenerNuevaPersona()
        //{
        //    if (NuevaPersonaUserControl is null)
        //    {
        //        NuevaPersonaUserControl = new NuevaPersonaUserControl();
        //    }
        //    return NuevaPersonaUserControl;
        //}

        //public UserControl ObtenerListadoPersonas()
        //{
        //    if (listadoPersonasVista is null)
        //    {
        //        listadoPersonasVista = new ListadoPersonasUserControl();
        //    }
        //    return listadoPersonasVista;
        //}

        //public UserControl ObtenerConsultaPersonas()
        //{
        //    //if (consultaPersonaUserControl is null)
        //    //{
        //    //    consultaPersonaUserControl = new ConsultaPersonaUserControl();
        //    //}
        //    //return consultaPersonaUserControl;

        //    return new ConsultaPersonaUserControl();
        //}

        //public void AbrirDialogoNacionalidad()
        //{
        //    DialogoNacionalidad dialogo = new DialogoNacionalidad();
        //    dialogo.ShowDialog();
        //}

        //public void CerrarDialogoNacionalidad(DialogoNacionalidad dialogo)
        //{
        //    // Con poner "DialogResult=true" se cierra la ventana modal.
        //    // No se necesita llamar al método "Close()" de la ventana.
        //    dialogo.DialogResult = true;
        //}
    }
}
