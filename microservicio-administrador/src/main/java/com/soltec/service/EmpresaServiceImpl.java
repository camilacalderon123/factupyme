package com.soltec.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.soltec.entities.Empresa;
import com.soltec.repository.EmpresaRepository;


@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Empresa> findAll(Pageable pagebale) {
		return empresaRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Empresa> findById(Integer NIT) {
		return empresaRepository.findById(NIT);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	@Override
	@Transactional
	public void deleteById(Integer NIT) {
		empresaRepository.deleteById(NIT);
	}
}
