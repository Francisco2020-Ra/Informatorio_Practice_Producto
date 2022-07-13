
# Informatorio Practice Product

CRUD Product. We have an Api Rest, perform the operations for the product resource. Where
product has the following attributes:



## Features
Product
- Id
- Name
- Description
- Unit Price


## Requirement #1 (CRUD Or ABM Operations)

- #1A - ADD A PRODUCT
- #1B - GET A PRODUCT ACCORDING TO YOUR ID
- #1C - GET ALL PRODUCTS
- #1D - MODIFY A PRODUCT ACCORDING TO ITS ID
- #1E - DELETE A PRODUCT BY ITS ID


## API Reference

#### Add a Product
- Criteria of acceptance #1A
```http
    POST /api/v1/product
```

| Body                   | Status Code   | JSON               |
| :--------------------- | :------- | :------------------------- |
| `{"name":"productX","description": "descX", "unitPrice": 123.99}` | `201:Created` | `{"id":1,"name":"productX","description": "descX", "unitPrice": 123.99}` |

#### addProduct(productDTO)
Receives a product and adds it to the database

#### Get Product Id
- Criteria of acceptance #1B

```http
  GET /api/v1/product/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of product to fetch |


| Body            | Status Code   | JSON               |
| :-------------- | :------- | :------------------------- |
|                 | `200:Ok` | `{"id":1,"name":"productX","description": "descX", "unitPrice": 123.99}` |

#### getProductId(id)

Receives a long type id of the product to search for and returns the product

#### Get Product
- Criteria of acceptance #1C

```http
  GET /api/v1/product
```


| Body            | Status Code   | JSON               |
| :-------------- | :------- | :------------------------- |
|                 | `200:Ok` | `[{"id":1,"name":"productX","description": "descX", "unitPrice": 123.99},{"id":2,"name":"productX","description": "descX", "unitPrice": 123.99}]` |

#### getAllProduct()

Returns a list of products

#### Update Product
- Criteria of acceptance #1D

```http
  PUT /api/v1/product/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of product to fetch |

| Body            | Status Code   | JSON               |
| :-------------- | :------- | :------------------------- |
| `{id":1,"name":"productH","description":"descX","unitPrice":123.99}` | `200:Ok` | `{"id":1,"name":"productH","description": "descX", "unitPrice": 123.99}` |

#### udpateProduct(id, productDTO)

Receives a long type id and the new product data of the product to be modified, then returns it modified

#### Delete Product Id
- Criteria of acceptance #1E

```http
  DELETE /api/v1/product/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of product to fetch |

| Body            | Status Code   | JSON               |
| :-------------- | :------- | :------------------------- |
| |`204:No Content` |  |

#### deleteProductId(id)

Receive the id of the product to be deleted and return status 204