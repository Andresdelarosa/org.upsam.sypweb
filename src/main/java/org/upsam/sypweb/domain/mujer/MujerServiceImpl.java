package org.upsam.sypweb.domain.mujer;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.upsam.sypweb.domain.mujer.domicilio.Provincia;
import org.upsam.sypweb.domain.mujer.domicilio.ProvinciaRepository;
import org.upsam.sypweb.domain.mujer.domicilio.TipoDireccion;
import org.upsam.sypweb.domain.mujer.domicilio.TipoDireccionRepository;
import org.upsam.sypweb.view.BusqMujerView;
import org.upsam.sypweb.view.MujerView;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Transactional(readOnly = true)
@Service
public class MujerServiceImpl implements MujerService {

	/**
	 * Repositorio del agregado {@link Mujer}
	 */
	private MujerRepository mujerRepository;
	/**
	 * Repositorio de la entidad {@link Provincia}
	 */
	private ProvinciaRepository provinciaRepository;
	/**
	 * Repositorio de la entidad {@link TipoDireccion}
	 */
	private TipoDireccionRepository tipoDireccionRepository;
	/**
	 * Converter de {@link Mujer} a {@link MujerView}
	 */
	private MujerConverter mujerConverter;

	/**
	 * @param mujerRepository
	 */
	@Inject
	public MujerServiceImpl(MujerRepository mujerRepository,
			ProvinciaRepository provinciaRepository,
			TipoDireccionRepository tipoDireccionRepository,
			MujerConverter mujerConverter) {
		super();
		this.mujerRepository = mujerRepository;
		this.provinciaRepository = provinciaRepository;
		this.tipoDireccionRepository = tipoDireccionRepository;
		this.mujerConverter = mujerConverter;
	}

	@Override
	public List<MujerView> findAll(BusqMujerView filter) {
		return mujerConverter.convert(mujerRepository
				.findAll(getPredicate(filter)));
	}

	@Override
	public Mujer find(Long id) {
		return mujerRepository.findOne(id);
	}

	@Override
	@Transactional
	public void save(Mujer mujer) {
		mujer.setFechaAlta(new Date());
		mujerRepository.save(mujer);
	}

	@Override
	public List<Provincia> getProvincias() {
		return provinciaRepository.findAll(new Sort("nombre"));
	}

	@Override
	public List<TipoDireccion> getTiposDireccion() {
		return tipoDireccionRepository.findAll(new Sort("tipo"));
	}

	private Predicate getPredicate(BusqMujerView filter) {
		if (filter != null) {
			BooleanExpression be = null;
			String nombre = filter.getNombre();
			String ap1 = filter.getApellido1();
			String ap2 = filter.getApellido2();
			String dni = filter.getDni();
			String tFijo = filter.getTelfFijo();
			String tMovil = filter.getTelfMovil();
			if (StringUtils.hasText(nombre)) {
				be = QMujer.mujer.nombre.nombre.like(nombre);
			}
			if (StringUtils.hasText(ap1)) {
				BooleanExpression ap1Like = QMujer.mujer.nombre.apellido1
						.like(ap1);
				be = be != null ? be.and(ap1Like) : ap1Like;
			}
			if (StringUtils.hasText(ap2)) {
				BooleanExpression ap2Like = QMujer.mujer.nombre.apellido1
						.like(ap2);
				be = be != null ? be.and(ap2Like) : ap2Like;
			}
			if (StringUtils.hasText(dni)) {
				BooleanExpression dniEq = QMujer.mujer.nombre.dni.eq(dni);
				be = be != null ? be.and(dniEq) : dniEq;
			}
			if (StringUtils.hasText(tFijo)) {
				BooleanExpression tFijoEq = QMujer.mujer.telfFijo.eq(tFijo);
				be = be != null ? be.and(tFijoEq) : tFijoEq;
			}
			if (StringUtils.hasText(tMovil)) {
				BooleanExpression tMovilEq = QMujer.mujer.telfFijo.eq(tMovil);
				be = be != null ? be.and(tMovilEq) : tMovilEq;
			}
			return be;
		}
		return null;
	}

}
