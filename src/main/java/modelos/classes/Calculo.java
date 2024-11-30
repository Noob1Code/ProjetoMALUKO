/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import modelos.enums.ClassificacaoIDH;
import modelos.interfaces.ICalculo;

/**
 *
 * @author aluno
 */
public class Calculo implements ICalculo{

    @Override
    public String DensidadeDemografica(String Populacao, String AreaKm2) {
        double densidade = Double.parseDouble(Populacao)/Double.parseDouble(AreaKm2);
        return String.format("%.2f", densidade).replace(",", ".");
    }

    @Override
    public String PibPerCapitaTotal(String PibTotal, String Populacao) {
        double PibPCT = Double.parseDouble(PibTotal)/Double.parseDouble(Populacao);
        return String.format("%.2f", PibPCT).replace(",", ".");
    }

    @Override
    public String ClassificacaoIDH(String IDH) {
        double clasIDH = Double.parseDouble(IDH);

        if (clasIDH > 0.80) return ClassificacaoIDH.Muito_Alto.getDescricao();
        if (clasIDH >= 0.70) return ClassificacaoIDH.Alto.getDescricao();
        if (clasIDH >= 0.55) return ClassificacaoIDH.Medio.getDescricao();
        if (clasIDH >= 0) return ClassificacaoIDH.Baixo.getDescricao();

        return "IDH não pode ser abaixo de 0";
    }
}
