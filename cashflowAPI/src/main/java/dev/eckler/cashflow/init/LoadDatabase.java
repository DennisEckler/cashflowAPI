package dev.eckler.cashflow.init;

import dev.eckler.cashflow.model.category.Category;
import dev.eckler.cashflow.model.category.CategoryRepository;
import dev.eckler.cashflow.model.identifier.Identifier;
import dev.eckler.cashflow.model.identifier.IdentifierRepository;
import dev.eckler.cashflow.model.transaction.TransactionRepository;
import dev.eckler.cashflow.model.transaction.TransactionService;
import dev.eckler.cashflow.shared.TransactionType;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Profile("dev")
class LoadDatabase {

  static final String USERID = "5276b7e0-4c55-49d7-bf52-46e34ab673cb";

  @Bean
  @Transactional
  CommandLineRunner initDatabase(TransactionRepository transactionRepository,
      TransactionService transaktionService,
      IdentifierRepository identifierRepository,
      CategoryRepository categoryRepository,
      ResourceLoader resourceloader) {

    return args -> {
      categoryRepository.saveAll(getCategories());
      initIdentifier(identifierRepository, categoryRepository);
    };
  }

  private List<Category> getCategories() {

    return Arrays.asList(
        new Category("dennis",
            USERID, TransactionType.INCOME),
        new Category("sveti",
            USERID, TransactionType.INCOME),
        new Category("gutschrift",
            USERID, TransactionType.INCOME),
        new Category("miete",
            USERID, TransactionType.FIXED),
        new Category("strom",
            USERID, TransactionType.FIXED),
        new Category("internet",
            USERID, TransactionType.FIXED),
        new Category("handy",
            USERID, TransactionType.FIXED),
        new Category("versicherung",
            USERID, TransactionType.FIXED),
        new Category("gez",
            USERID, TransactionType.FIXED),
        new Category("abonnement",
            USERID, TransactionType.FIXED),
        new Category("lebensmittel",
            USERID, TransactionType.VARIABLE),
        new Category("haushaltsmittel",
            USERID, TransactionType.VARIABLE),
        new Category("kleidung",
            USERID, TransactionType.VARIABLE),
        new Category("mobilitaet",
            USERID, TransactionType.VARIABLE),
        new Category("geschenke",
            USERID, TransactionType.VARIABLE),
        new Category("ausgehen",
            USERID, TransactionType.VARIABLE),
        new Category("sonstiges",
            USERID, TransactionType.VARIABLE)
    );
  }

  private void initIdentifier(IdentifierRepository identifierRepository,
      CategoryRepository categoryRepository) {
    identifierRepository.saveAll(Arrays.asList(
        new Identifier("bertelsmann", categoryRepository.findByCategoryLabel("dennis")),
        new Identifier("abas", categoryRepository.findByCategoryLabel("dennis")),
        new Identifier("neschen", categoryRepository.findByCategoryLabel("dennis")),
        new Identifier("mait", categoryRepository.findByCategoryLabel("dennis")),
        new Identifier("arvato", categoryRepository.findByCategoryLabel("dennis")),
        new Identifier("kammann", categoryRepository.findByCategoryLabel("sveti")),
        new Identifier("rainer klenke", categoryRepository.findByCategoryLabel("miete")),
        new Identifier("logemann vermoegensverwaltung", categoryRepository.findByCategoryLabel("miete")),
        new Identifier("e.on energie", categoryRepository.findByCategoryLabel("strom")),
        new Identifier("stromio gmbh", categoryRepository.findByCategoryLabel("strom")),
        new Identifier("vodafone", categoryRepository.findByCategoryLabel("internet")),
        new Identifier("telefonica", categoryRepository.findByCategoryLabel("handy")),
        new Identifier("drillisch online gmbh", categoryRepository.findByCategoryLabel("handy")),
        new Identifier("lvm landw.versicherungsverein", categoryRepository.findByCategoryLabel("versicherung")),
        new Identifier("beitragsservice von ard", categoryRepository.findByCategoryLabel("gez")),
        new Identifier("spotify", categoryRepository.findByCategoryLabel("abonnement")),
        new Identifier("igm herford", categoryRepository.findByCategoryLabel("abonnement")),
        new Identifier("netflix", categoryRepository.findByCategoryLabel("abonnement")),
        new Identifier("BoRa Sports GmbH", categoryRepository.findByCategoryLabel("abonnement")),
        new Identifier("FitX Deutschland GmbH", categoryRepository.findByCategoryLabel("abonnement")),
        new Identifier("wez", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("LIDL", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("E-CENTER", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("KAUFLAND", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("ALDI", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("Combi Verbrauchermarkt", categoryRepository.findByCategoryLabel("lebensmittel")),
        new Identifier("rossmann", categoryRepository.findByCategoryLabel("haushaltsmittel")),
        new Identifier("DM DROGERIEMARKT", categoryRepository.findByCategoryLabel("haushaltsmittel")),
        new Identifier("c+a", categoryRepository.findByCategoryLabel("kleidung")),
        new Identifier("zalando", categoryRepository.findByCategoryLabel("kleidung")),
        new Identifier("hauptzollamt bielefeld", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("unicredit", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("aral ag", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("jet dankt", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("Deutsche Tamoil GmbH", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("TAS Minden", categoryRepository.findByCategoryLabel("mobilitaet")),
        new Identifier("landbaeckerei niemeyer", categoryRepository.findByCategoryLabel("ausgehen")),
        new Identifier("ing", categoryRepository.findByCategoryLabel("sonstiges")),
        new Identifier("elsner catering", categoryRepository.findByCategoryLabel("sonstiges"))
    ));
  }

}
