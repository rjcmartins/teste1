package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CEP {

public static final int TIMEOUT = 300;

/**
 *
 * CEP
 *
 * @author Rafael Juan Cardoso Martins
 * @since 13/03/2023, 13:05:38
 *
 */
public static Var Consultar() throws Exception {
 return new Callable<Var>() {

   private Var CEP = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    CEP =
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.CEP"));
    item =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/x-www-form-urlencoded"),
    Var.valueOf(
    Var.valueOf("https://viacep.com.br/ws/").getObjectAsString() +
    CEP.getObjectAsString() +
    Var.valueOf("/json/").getObjectAsString()), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Endereco.active.logradouro"),
    cronapi.json.Operations.getJsonOrMapField(item,
    Var.valueOf("logradouro")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Endereco.active.bairro"),
    cronapi.json.Operations.getJsonOrMapField(item,
    Var.valueOf("bairro")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Endereco.active.uf"),
    cronapi.json.Operations.getJsonOrMapField(item,
    Var.valueOf("uf")));
    return Var.VAR_NULL;
   }
 }.call();
}

}

