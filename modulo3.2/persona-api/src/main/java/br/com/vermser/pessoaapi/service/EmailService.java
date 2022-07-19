package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.EnderecoDTO;
import br.com.vermser.pessoaapi.dto.PessoaDTO;
import br.com.vermser.pessoaapi.enums.TipoDeMensagem;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String from;


    public void novoCadastroSimpleMessage(PessoaDTO pessoaDTO) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoaDTO.getEmail());
        message.setSubject("Bem vindo!");
        message.setText("Óla "+pessoaDTO.getNome() + "\n" +
                "Estamos felizes de ter você no nosso sistema :)\n" +
                "Seu cadastro foi realizado com sucesso, seu identificador id é: "+pessoaDTO.getIdPessoa()+
                "Qualquer duvida é só contatar o suporte pelo email : suporte@dbccompany.com.br ");

        emailSender.send(message);
    }

    public void updateSimpleMessage(PessoaDTO pessoaDTO) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoaDTO.getEmail());
        message.setSubject("Atualização de cadastro");
        message.setText("Óla "+pessoaDTO.getNome() + "\n" +
                "Seus dados foram atualizados em nosso sistema :)\n" +
                "Qualquer duvida é só contatar nosso suporte pelo em  suporte@dbccompany.com.br\n\n"+
                "Att,\n" +
                "Sistema."
               );

        emailSender.send(message);
    }

    public void deleteSimpleMessage(PessoaDTO pessoaDTO) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoaDTO.getEmail());
        message.setSubject("Exclusão de cadastro");
        message.setText("Óla "+pessoaDTO.getNome() + "\n" +
                "Você perdeu acesso ao nosso sistema.\n" +
                "Qualquer duvida é só contatar nosso suporte pelo em "+from+"\n\n"+
                "Att,\n" +
                "Sistema."
        );

        emailSender.send(message);
    }

    public void sendEmail(PessoaDTO pessoaDTO, EnderecoDTO enderecoDTO, String tipoMensagem) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            if(tipoMensagem.equals(TipoDeMensagem.CREATE.getTipoDeMensagem())){
                mimeMessageHelper.setSubject("Cadastro realizado");
            }else if (tipoMensagem.equals(TipoDeMensagem.UPDATE.getTipoDeMensagem())){
                mimeMessageHelper.setSubject("Cadastro atualizado");
            }else{
                mimeMessageHelper.setSubject("Cadastro deletado");
            }
            mimeMessageHelper.setText(geContentFromTemplate(pessoaDTO, enderecoDTO,tipoMensagem), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplate(PessoaDTO pessoaDTO, EnderecoDTO enderecoDTO, String tipoMensagem) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", enderecoDTO.getIdEndereco());
        dados.put("email", from);
        Template template;
        if(tipoMensagem.equals(TipoDeMensagem.CREATE.getTipoDeMensagem())){
            template = fmConfiguration.getTemplate("email_adicionar_endereco-template.ftl");
        }else if (tipoMensagem.equals(TipoDeMensagem.UPDATE.getTipoDeMensagem())){
            template = fmConfiguration.getTemplate("email_atualizar_endereco-template.ftl");
        }else{
            template = fmConfiguration.getTemplate("email_deletar_endereco-template.ftl");
        }

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

}
