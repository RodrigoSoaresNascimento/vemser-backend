package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.PetDTO;
import br.com.vermser.pessoaapi.entity.PessoaEntity;
import br.com.vermser.pessoaapi.entity.PetEntity;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public PetEntity converterPetDTO (PetDTO petDTO) {
        return objectMapper.convertValue(petDTO, PetEntity.class);
    }

    public PetDTO converterpet (PetEntity pet){
        return objectMapper.convertValue(pet, PetDTO.class);
    }

    public PetDTO create (Integer idPessoa, PetDTO pet) {
        PessoaEntity pessoa = pessoaService.findById(idPessoa);
        PetEntity petEntity = converterPetDTO(pet);
        petEntity.setPessoa(pessoa);
        pet.setIdPessoa(idPessoa);
        petEntity = repository.save(petEntity);
        PetDTO petDTO = converterpet(petEntity);
        return petDTO;
    }

    public List<PetDTO> list (){
        return repository.findAll()
                .stream()
                .map(this::converterpet)
                .collect(Collectors.toList());
    }

    public PetDTO update (Integer id
            , PetDTO petAtualizar) throws Exception {

        PetEntity petRecuperado = findById(id);
        PessoaEntity pessoaRecuperado = petRecuperado.getPessoa();
        pessoaRecuperado.setPetEntity(null);

        PessoaEntity pessoaEntity = pessoaService.findById(petAtualizar.getIdPessoa());
        petRecuperado.setIdPet(id);
        petRecuperado.setNome(petAtualizar.getNome());
        petRecuperado.setTipo(petAtualizar.getTipo());
        petRecuperado.setPessoa(pessoaRecuperado);
        pessoaRecuperado.setPetEntity(petRecuperado);
        pessoaService.savePersonEntity(pessoaRecuperado);
        if(!pessoaRecuperado.getIdPessoa().equals(pessoaEntity.getIdPessoa())){
            pessoaService.savePersonEntity(pessoaEntity);
        }
        return converterpet(repository.save(petRecuperado));
    }

    public PetEntity findById(Integer id) {
        PetEntity pet = repository.findById(id)
                .orElseThrow(() -> new PessoaNaoCadastradaException("PessoaEntity não econtrada"));
        return pet;
    }

    public void delete (Integer id) throws Exception {
        PetEntity petRecuperada = findById(id);
        repository.delete(petRecuperada);
    }

    public List<PetDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::converterpet)
                .collect(Collectors.toList());
    }

}
