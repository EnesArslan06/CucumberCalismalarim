Feature: Heroquapp Testing

  Scenario: Heroquapp ilkTest

    Given kullanici "HerokuappAddElementUrl" sayfasina gider
    When Add Element butonuna basar
    Then Delete butonu gorununceye kadar bekler
    And Delete butonunun gorundgunu test eder
    Then Delete butonuna basarak butonu siler
    And 1 saniye bekler
    And sayfayi kapatir

    Scenario: Herokuapp ikinciTest

      Given kullanici Herokuapp sayfasina gider
      Then Dropdown butonuna tiklar
      Then Butun secenekleri ekrana yazdirir
      And Option1 secenegini secer
      And sayfayi kapatir


