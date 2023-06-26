package edu.cibertec.stockwarehouse;

import com.github.javafaker.Faker;
import edu.cibertec.stockwarehouse.cabecerainventario.infrastructure.out.CabeceraInventarioRepository;
import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import edu.cibertec.stockwarehouse.cargo.infrastructure.out.CargoRepository;
import edu.cibertec.stockwarehouse.categoria.domain.model.Categoria;
import edu.cibertec.stockwarehouse.categoria.infrastructure.out.CategoriaRepository;
import edu.cibertec.stockwarehouse.detalleinventario.infrastructure.out.DetalleInventarioRepository;
import edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.out.DetalleOrdenCompraRepository;
import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import edu.cibertec.stockwarehouse.empleado.infrastructure.out.EmpleadoRepository;
import edu.cibertec.stockwarehouse.ordencompra.infrastructure.out.OrdenCompraRepository;
import edu.cibertec.stockwarehouse.producto.domain.model.Producto;
import edu.cibertec.stockwarehouse.producto.infrastructure.out.ProductoRepository;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import edu.cibertec.stockwarehouse.proveedor.infrastructure.out.ProveedorRepository;
import edu.cibertec.stockwarehouse.tipousuario.domain.model.TipoUsuario;
import edu.cibertec.stockwarehouse.tipousuario.infrastructure.out.TipoUsuarioRepository;
import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import edu.cibertec.stockwarehouse.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GenerateSampleData implements CommandLineRunner {
    private final CargoRepository cargoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final CabeceraInventarioRepository cabeceraInventarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final DetalleInventarioRepository detalleInventarioRepository;
    private final DetalleOrdenCompraRepository detalleOrdenCompraRepository;
    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final Faker faker;

    public GenerateSampleData(
            CargoRepository cargoRepository,
            EmpleadoRepository empleadoRepository,
            CabeceraInventarioRepository cabeceraInventarioRepository,
            CategoriaRepository categoriaRepository,
            DetalleInventarioRepository detalleInventarioRepository,
            DetalleOrdenCompraRepository detalleOrdenCompraRepository,
            OrdenCompraRepository ordenCompraRepository,
            ProductoRepository productoRepository,
            ProveedorRepository proveedorRepository,
            TipoUsuarioRepository tipoUsuarioRepository,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            Faker faker) {
        this.cargoRepository = cargoRepository;
        this.empleadoRepository = empleadoRepository;
        this.cabeceraInventarioRepository = cabeceraInventarioRepository;
        this.categoriaRepository = categoriaRepository;
        this.detalleInventarioRepository = detalleInventarioRepository;
        this.detalleOrdenCompraRepository = detalleOrdenCompraRepository;
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoRepository = productoRepository;
        this.proveedorRepository = proveedorRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Cargo> cargos = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Cargo cargo = new Cargo();
                    cargo.setNombre(faker.company().profession());
                    cargo.setEstado(faker.number().numberBetween(0, 2));
                    return cargo;
                }).collect(Collectors.toList());
        cargoRepository.saveAll(cargos);

        List<TipoUsuario> tipoUsuarios = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    TipoUsuario tipoUsuario = new TipoUsuario();
                    tipoUsuario.setEstado(faker.number().numberBetween(0, 2));
                    tipoUsuario.setNombreTipoUsuario(faker.job().position());
                    return tipoUsuario;
                }).collect(Collectors.toList());
        tipoUsuarioRepository.saveAll(tipoUsuarios);

        List<Categoria> categorias = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Categoria categoria = new Categoria();
                    categoria.setEstado(faker.number().numberBetween(0, 2));
                    categoria.setNombre(faker.commerce().productName());
                    return categoria;
                }).collect(Collectors.toList());
        categoriaRepository.saveAll(categorias);

        List<Proveedor> proveedors = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setEstado(faker.number().numberBetween(0, 2));
                    proveedor.setEmail(faker.internet().emailAddress());
                    proveedor.setTelefono(faker.phoneNumber().phoneNumber());
                    proveedor.setRuc(String.valueOf(faker.number().numberBetween(111111111, 999999999)));
                    proveedor.setRazonSocial(faker.company().name());
                    proveedor.setDireccion(faker.address().buildingNumber());
                    return proveedor;
                }).collect(Collectors.toList());
        proveedorRepository.saveAll(proveedors);

        List<Empleado> empleados = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Cargo cargo = cargos.get(faker.number().numberBetween(0, 5));
                    Empleado empleado = new Empleado();
                    empleado.setNombre(faker.name().firstName());
                    empleado.setApellido(faker.name().lastName());
                    empleado.setEstado(faker.number().numberBetween(0, 2));
                    empleado.setCorreo(faker.internet().emailAddress());
                    empleado.setFechaCese(faker.date().birthday());
                    empleado.setFechaIngreso(faker.date().birthday());
                    empleado.setTelefono(faker.phoneNumber().phoneNumber());
                    empleado.setCargo(cargo);
                    return empleado;
                }).collect(Collectors.toList());
        empleadoRepository.saveAll(empleados);

        List<Usuario> usuarios = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Empleado empleado = empleados.get(faker.number().numberBetween(0, 5));
                    TipoUsuario tipoUsuario = tipoUsuarios.get(faker.number().numberBetween(0, 5));
                    Usuario usuario = new Usuario();
                    usuario.setEstado(faker.number().numberBetween(0, 2));
                    usuario.setTipoUsuario(tipoUsuario);
                    usuario.setEmpleado(empleado);
                    usuario.setLogin_usuario(faker.name().username());
                    usuario.setContrasena_usuario(passwordEncoder.encode("123"));
                    return usuario;
                }).collect(Collectors.toList());
        usuarioRepository.saveAll(usuarios);

        List<Producto> productos = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    Categoria categoria = categorias.get(faker.number().numberBetween(0, 5));
                    Producto producto = new Producto();
                    producto.setCategoria(categoria);
                    producto.setEstado(faker.number().numberBetween(0, 2));
                    producto.setMarca(faker.commerce().productName());
                    producto.setDescripcion(faker.commerce().material() + faker.commerce().color());
                    producto.setStock(faker.number().numberBetween(0, 30));
                    producto.setCodigobarra(faker.commerce().promotionCode().substring(0, 13));
                    return producto;
                }).collect(Collectors.toList());
        productoRepository.saveAll(productos);
    }
}
