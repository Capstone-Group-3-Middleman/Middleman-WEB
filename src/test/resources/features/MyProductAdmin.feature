Feature: My product on with role admin

  @MyProductAdmin
  Scenario Outline: Verify input add product with complete input require
#    setiap menjalankan data tidak boleh sama
    Given Admin already login
    When Admin already on my product page
    And Admin click add product
    And Admin choose image product "<image>"
    And Admin input Product Name "<productName>" Unit "<unit>" Stock "<stock>" Price "<price>"
#  [MPA-07]Verify button add on modal add product
    And Admin click add on form modal add product
    And Click alert add product
    Then verify product "<productName>"
    Examples:
      | image       | productName | unit | stock | price |
#  [MPA-01] Verify input add product with complete input require
      | gambar1.jpg | i19         | 2    | 2     | 2000  |

  @MyProductAdmin
  Scenario Outline: Verify input add product with incomplete input require
    Given Admin already login
    When Admin already on my product page
    And Admin click add product
    And Admin choose image product "<image>"
    And Admin input Product Name "<productName>" Unit "<unit>" Stock "<stock>" Price "<price>"
    And Admin click add on form modal add product
    Examples:
      | image       | productName | unit | stock | price |
#  [MPA-02] Verify input add product without choose file image
      |             | i19         | 2    | 2     | 2000  |
#  [MPA-03] Verify input add product without type fiield product name
      | gambar1.jpg |             | 2    | 2     | 2000  |
#  [MPA-04] Verify input add product without type fiield unit
      | gambar1.jpg | i19         |      | 2     | 2000  |
#  [MPA-05] Verify input add product without type fiield stock
      | gambar1.jpg | i19         | 2    |       | 2000  |
 #  [MPA-06] Verify input add product without type fiield price
      | gambar1.jpg | i19         | 2    | 2     |       |

  @MyProductAdmin
  Scenario Outline: Admin Edit product
    Given Admin already login
#  [MPA-08] Verify button edit on my product page
    When Admin click edit on "<productName>" card body
    And Clear field edit product "<productName>"
    And Admin edit "<productName>" field image "<Image>" Product Name "<productNames>" Unit "<unit>" Stock "<stock>" Price "<price>"
    And Admin click button edit
    Examples:
      | productName | Image | productNames | unit | stock | price |
 #  [MPA-08] Verify input edit product with complete input require
      | i19         | 1.jpg | kabelsy18    | pcs  | 1     | 2000  |


  @MyProductAdmin
  Scenario Outline: Admin Edit product
    Given Admin already login
    When Admin click edit on "<productName>" card body
    And Clear field edit product "<productName>"
    And Admin edit "<productName>" field image "<Image>" Product Name "<productNames>" Unit "<unit>" Stock "<stock>" Price "<price>"
#  [MPA-14] Verify button add on modal add product on modal edit my product
    And Admin click button edit
    Examples:
      | productName | Image | productNames | unit | stock | price |
#  [MPA-09] Verify input edit product without choose file image
      | kabelsy18   |       | 19s          | pcs  | 1     | 2000  |
#  [MPA-10] Verify input edit product without type field product name
      | kabelsy18   | 1.jpg |              | pcs  | 1     | 2000  |
#  [MPA-11] Verify input edit product without type field unit
      | kabelsy18   | 1.jpg | 19s          |      | 1     | 2000  |
#  [MPA-12] Verify input edit product without type field stock
      | kabelsy18   | 1.jpg | 19s          | pcs  |       | 2000  |
#  [MPA-13] Verify edit add product without type fiield price
      | kabelsy18   | 1.jpg | 19s          | pcs  | 1     |       |


#  [MPA-18-MPA-19 ] Verify button search product and Verify field search product
  @MyProductAdmin
  Scenario: Admin Search Product
    Given Admin already login
    When Admin type product to search "kabelsy18"
    And Admin click button to search
    Then Product "kabelsy18" is displayed

#  [MPA-19] Verify button add product stock
  @MyProductAdmin
  Scenario:Add product out to inbound
    Given Admin already login
    When Admin click button add product out "kabelsy18"
    And Accept alert add product
    And Admin go to inbound to verify product
#    ubah verify
    Then Product is displayed on inbound
    When Admin click button submit to

#  [MPA-20] Verify button delete product on my product page
  @MyProductAdmin
  Scenario: Verify button delete product on my product page
    Given Admin already login
    When Admin click delete product "kabelsy18"
    And verify functional button Yes and No in modal "kabelsy18"