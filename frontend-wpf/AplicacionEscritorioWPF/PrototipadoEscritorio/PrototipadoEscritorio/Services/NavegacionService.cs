using PrototipadoEscritorio.Views;
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
        private static UserControl usuariosVista, accesoriosVista, eventosVista, comunidadesVista;
        public UserControl ObtenerVentanaUsuarios()
        {
            if (usuariosVista is null)
            {
                usuariosVista = new UsuariosUserControl();
            }
            return usuariosVista;
        }

        public UserControl ObtenerVentanaAccesorios()
        {
            if (accesoriosVista is null)
            {
                accesoriosVista = new AccesoriosUserControl();
            }
            return accesoriosVista;
        }

        public UserControl ObtenerVentanaEventos()
        {
            if (eventosVista is null)
            {
                eventosVista = new EventosUserControl();
            }
            return eventosVista;
        }

        public UserControl ObtenerVentanaComunidades()
        {
            if (comunidadesVista is null)
            {
                comunidadesVista = new ComunidadesUserControl();
            }
            return comunidadesVista;
        }

    }
}
