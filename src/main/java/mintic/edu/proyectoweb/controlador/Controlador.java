package mintic.edu.proyectoweb.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mintic.edu.proyectoweb.modelo.Cliente;
import mintic.edu.proyectoweb.modelo.ClienteDAO;
import mintic.edu.proyectoweb.modelo.Proveedor;
import mintic.edu.proyectoweb.modelo.ProveedorDAO;
import mintic.edu.proyectoweb.modelo.Usuario;
import mintic.edu.proyectoweb.modelo.UsuarioDAO;

public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    String aviso = null;
    String mensaje = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "Listar":
                    String tipos[] = {"Administrador", "Cliente"};
                    request.setAttribute("usuarios", usuarioDao.getUsuarios());
                    request.setAttribute("tipos", tipos);
                    request.setAttribute("usuarioEdit", new Usuario());
                    break;
                case "Agregar":
                    try {
                    int idUsuario = Integer.parseInt(request.getParameter("txtId"));
                    String nombreUsuario = request.getParameter("txtNombre");
                    String correo = request.getParameter("txtCorreo");
                    String nombreCompleto = request.getParameter("txtNombreC");
                    String clave = request.getParameter("txtClave");
                    String tipoUsuario = request.getParameter("txtTipo");
                    if (nombreUsuario.isEmpty() || correo.isEmpty() || nombreCompleto.isEmpty()
                            || clave.isEmpty() || tipoUsuario.isEmpty()) {
                        aviso = "ERROR: Faltan datos del usuario ";
                        mensaje = null;
                    } else {
                        usuario.setIdUsuario(idUsuario);
                        usuario.setNombreUsuario(nombreUsuario);
                        usuario.setCorreo(correo);
                        usuario.setNombreCompleto(nombreCompleto);
                        usuario.setClave(clave);
                        usuario.setTipoUsuario(tipoUsuario);
                        boolean creado = usuarioDao.agregarUsuario(usuario);
                        if (creado) {
                            mensaje = "Usuario CREADO exitosamente";
                            aviso = null;
                        } else {
                            aviso = "ERROR: Faltan datos del usuario ";
                            mensaje = null;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("aviso", aviso);
                request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Usuario usu = new Usuario();
                    String[] categorias = {"Administrador", "Cliente"};
                    usu = usuarioDao.getUsuarioId(ideu);
                    request.setAttribute("usuarioEdit", usu);
                    request.setAttribute("categorias", categorias);
                    break;
                case "Actualizar":
                    int idUsuarioa = Integer.parseInt(request.getParameter("txtId"));
                    String nombreUsuarioa = request.getParameter("txtNombre");
                    String correoa = request.getParameter("txtCorreo");
                    String nombreCompletoa = request.getParameter("txtNombreC");
                    String clavea = request.getParameter("txtClave");
                    String tipoUsuarioa = request.getParameter("txtTipo");
                    if (nombreUsuarioa.isEmpty() || correoa.isEmpty() || nombreCompletoa.isEmpty()
                            || clavea.isEmpty() || tipoUsuarioa.isEmpty()) {
                        aviso = "ERROR: Faltan datos del usuario ";
                        mensaje = null;
                    } else {
                        usuario.setIdUsuario(idUsuarioa);
                        usuario.setNombreUsuario(nombreUsuarioa);
                        usuario.setCorreo(correoa);
                        usuario.setNombreCompleto(nombreCompletoa);
                        usuario.setClave(clavea);
                        usuario.setTipoUsuario(tipoUsuarioa);
                        boolean actualizado = usuarioDao.actualizarUsuario(usuario);
                        if (actualizado) {
                            mensaje = "Usuario ACTUALIZADO exitosamente";
                            aviso = null;
                        } else {
                            aviso = "ERROR: Faltan datos del usuario ";
                            mensaje = null;
                        }
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idUsuarioe = Integer.valueOf(request.getParameter("id"));
                    boolean eliminado = usuarioDao.eliminarUsuario(idUsuarioe);
                    if (eliminado) {
                        mensaje = "Usuario ELIMINADO Exitosamente";
                        aviso = null;
                    } else {
                        aviso = "ERROR: Faltan datos del cliente";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    int idUsuariob = Integer.parseInt(request.getParameter("txtId"));
                    Usuario usu1 = new Usuario();
                    usu1 = usuarioDao.getUsuarioId(idUsuariob);
                    String[] categoriasb = {"Administrador", "Cliente"};
                    if (usu1.getNombreUsuario() == null) {
                        aviso = "Usuario no existe";
                        mensaje = null;
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("aviso", aviso);
                        request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    } else {
                        mensaje = "Usuario ENCONTRADO";
                        aviso = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("categorias", categoriasb);
                    request.setAttribute("usuarioEdit", usu1);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/usuarios.jsp").forward(request, response);
        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List<Cliente> clientes = new ArrayList<Cliente>();
                    request.setAttribute("clientes", clienteDAO.getClientes());
                    request.setAttribute("clienteEdit", new Cliente());
                    break;
                case "Agregar":
                    int cedula = Integer.parseInt(request.getParameter("txtCedula"));
                    String nombrecompleto = request.getParameter("txtNombre");
                    String direccion = request.getParameter("txtDireccion");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    if (nombrecompleto.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                        aviso = "ERROR: !!! faltan datos del cliente";
                        mensaje = null;
                    } else {
                        cliente.setCedula(cedula);
                        cliente.setNombrecompleto(nombrecompleto);
                        cliente.setDireccion(direccion);
                        cliente.setTelefono(telefono);
                        cliente.setCorreo(correo);
                        boolean creado = clienteDAO.agregarCliente(cliente);
                        if (creado) {
                            mensaje = "Cliente CREADO Exitosamente";
                            aviso = null;
                        } else {
                            aviso = "Error. !!! faltan datos del cliente";
                            mensaje = null;
                        }
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int cedulau = Integer.valueOf(request.getParameter("id"));
                    Cliente cli = new Cliente();
                    cli = clienteDAO.getClienteId(cedulau);
                    request.setAttribute("clienteEdit", cli);
                    break;

                case "Actualizar":
                    int cedulaa = Integer.parseInt(request.getParameter("txtCedula"));
                    String nombrecompletoa = request.getParameter("txtNombre");
                    String direcciona = request.getParameter("txtDireccion");
                    String telefonoa = request.getParameter("txtTelefono");
                    String correoa = request.getParameter("txtCorreo");
                    if (nombrecompletoa.isEmpty() || direcciona.isEmpty() || telefonoa.isEmpty()
                            || correoa.isEmpty()) {
                        aviso = "ERROR:!!! Faltan datos del cliente";
                        mensaje = null;
                    } else {
                        cliente.setCedula(cedulaa);
                        cliente.setNombrecompleto(nombrecompletoa);
                        cliente.setDireccion(direcciona);
                        cliente.setTelefono(telefonoa);
                        cliente.setCorreo(correoa);
                        boolean actualizado = clienteDAO.actualizarCliente(cliente);
                        if (actualizado) {
                            mensaje = "Cliente ACTUALIZADO Exitosamente";
                            aviso = null;
                        } else {
                            aviso = "ERROR:!!! Faltan datos del cliente";
                            mensaje = null;
                        }
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("aviso", aviso);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    int cedulae = Integer.valueOf(request.getParameter("id"));
                    boolean eliminado = clienteDAO.eliminarCliente(cedulae);
                    if (eliminado) {
                        mensaje = "Cliente ELIMINADO Exitosamente";
                        aviso = null;
                    } else {
                        aviso = "ERROR: !!! faltan datos del cleinte";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    int cedulab = Integer.parseInt(request.getParameter("txtCedula"));
                    Cliente cli1 = new Cliente();
                    cli1 = clienteDAO.getClienteId(cedulab);
                    if (cli1.getNombrecompleto() == null) {
                        aviso = "Cliente no existe";
                        mensaje = null;
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("aviso", aviso);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    } else {
                        mensaje = "Cliente ENCONTRADO";
                        aviso = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("clienteEdit", cli1);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("jsp/clientes.jsp").forward(request, response);
        }
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    request.setAttribute("proveedores", proveedorDao.getProveedores());
                    request.setAttribute("proveedorEdit", new Proveedor());
                    break;
                case "Agregar":
                    int nit = Integer.parseInt(request.getParameter("txtCedula"));
                    String nombreproveedor = request.getParameter("txtNombre");
                    String direccion = request.getParameter("txtDireccion");
                    String telefono = request.getParameter("txtTelefono");
                    String ciudad = request.getParameter("txtCorreo");
                    if (nombreproveedor.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || ciudad.isEmpty()) {
                        aviso = "ERROR: !!! faltan datos del cliente";
                        mensaje = null;
                    } else {
                        proveedor.setNit(nit);
                        proveedor.setNombreproveedor(nombreproveedor);
                        proveedor.setDireccion(direccion);
                        proveedor.setTelefono(telefono);
                        proveedor.setCiudad(ciudad);
                        boolean creado = proveedorDao.agregarProveedor(proveedor);
                        if (creado) {
                            mensaje = "Cliente CREADO Exitosamente";
                            aviso = null;
                        } else {
                            aviso = "Error. !!! faltan datos del cliente";
                            mensaje = null;
                        }
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int nitu = Integer.valueOf(request.getParameter("id"));
                    Proveedor prov = new Proveedor();
                    prov = proveedorDao.getProveedorId(nitu);
                    request.setAttribute("proveedorEdit", prov);
                    break;

                case "Actualizar":
                    int nita = Integer.parseInt(request.getParameter("txtCedula"));
                    String nombreproveedora = request.getParameter("txtNombre");
                    String direcciona = request.getParameter("txtDireccion");
                    String telefonoa = request.getParameter("txtTelefono");
                    String ciudada = request.getParameter("txtCorreo");
                    if (nombreproveedora.isEmpty() || direcciona.isEmpty() || telefonoa.isEmpty()
                            || ciudada.isEmpty()) {
                        aviso = "ERROR:!!! Faltan datos del cliente";
                        mensaje = null;
                    } else {
                        proveedor.setNit(nita);
                        proveedor.setNombreproveedor(nombreproveedora);
                        proveedor.setDireccion(direcciona);
                        proveedor.setTelefono(telefonoa);
                        proveedor.setCiudad(ciudada);
                        boolean actualizado = proveedorDao.actualizarProveedor(proveedor);
                        if (actualizado) {
                            mensaje = "Proveedor ACTUALIZADO Exitosamente";
                            aviso = null;
                        } else {
                            aviso = "ERROR:!!! Faltan datos del cliente";
                            mensaje = null;
                        }
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("aviso", aviso);
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    int nite = Integer.valueOf(request.getParameter("id"));
                    boolean eliminado = proveedorDao.eliminarProveedor(nite);
                    if (eliminado) {
                        mensaje = "Proveedor ELIMINADO Exitosamente";
                        aviso = null;
                    } else {
                        aviso = "ERROR: !!! faltan datos del cleinte";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    int nitb = Integer.parseInt(request.getParameter("txtCedula"));
                    Proveedor prov1 = new Proveedor();
                    prov1 = proveedorDao.getProveedorId(nitb);
                    if (prov1.getNombreproveedor() == null) {
                        aviso = "Proveedor NO existe";
                        mensaje = null;
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("aviso", aviso);
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    } else {
                        mensaje = "Proveedor ENCONTRADO";
                        aviso = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("proveedorEdit", prov1);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("jsp/proveedores.jsp").forward(request, response);
        }
        if (menu.equals("Ventas")) {
            switch (accion) {
                case "Listar":

                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Eliminar":

                    break;
                case "Buscar":

                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("jsp/facturas.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
