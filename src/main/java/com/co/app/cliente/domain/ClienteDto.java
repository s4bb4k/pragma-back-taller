package com.co.app.cliente.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "Dto para el manejo de clientes")
@Data @AllArgsConstructor
public class ClienteDto {

    @ApiModelProperty(notes = "id del cliente")
    @JsonProperty("idcliente")
    private Integer id;

    @ApiModelProperty(notes = "nombre del cliente")
    @JsonProperty("nombre")
    private String nombre;

    @ApiModelProperty(notes = "apellido del cliente")
    @JsonProperty("apellido")
    private String apellido;

    @ApiModelProperty(notes = "fecha de nacimiento del cliente")
    @JsonProperty("fecha_nacimiento")
    private String fechanacimiento;

    @ApiModelProperty(notes = "id ciudad del cliente")
    @JsonProperty("idciudad")
    private Integer idciudad;

    @ApiModelProperty(notes = "id tipo documento del cliente")
    @JsonProperty("idtipodocumento")
    private Integer idtipodocumento;

	@ApiModelProperty(notes = "estado del cliente")
	@JsonProperty("estado")
	private String estado;

    @ApiModelProperty(notes = "id imagen del cliente")
    @JsonProperty("url")
    private String url;

	@ApiModelProperty(notes = "id imagen del cliente")
	@JsonProperty("id_imagen")
	private Integer idimagen;

	@ApiModelProperty(notes = "Base64 de la imagen")
	@JsonProperty("image_data")
	private String imageData;

	@ApiModelProperty(notes = "Nombre imagen tipo Producto")
	@JsonProperty("image_name")
	private String image_name;

	@ApiModelProperty(notes = "El tipo de imagen Producto")
	@JsonProperty("image_type")
	private String ext;

	@ApiModelProperty(notes = "Tamaño de la imagen para Producto")
	@JsonProperty("image_size")
	private String peso;

	public ClienteDto() {
	}

	/**
	 * 
	 * Encargado de obtener clientes y actualizarlos
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fecha_nacimiento
	 * @param idciudad
	 * @param idtipodocumento
	 * @param idimagen
	 */
	public ClienteDto(Integer id, String nombre, String apellido, String fecha_nacimiento, Integer idciudad,
			Integer idtipodocumento, Integer idimagen) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fecha_nacimiento;
		this.idciudad = idciudad;
		this.idtipodocumento = idtipodocumento;
		this.idimagen = idimagen;
	}

	
	/**
	 * constructor para crear cliente
	 *
	 * @param nombre
	 * @param apellido
	 * @param fecha_nacimiento
	 * @param idciudad
	 * @param idtipodocumento
	 * @param idimagen
	 * @param estado
	 */
	public ClienteDto(String nombre, String apellido, String fecha_nacimiento, Integer idciudad,
			Integer idtipodocumento, Integer idimagen, String estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fecha_nacimiento;
		this.idciudad = idciudad;
		this.idtipodocumento = idtipodocumento;
		this.idimagen = idimagen;
		this.estado = estado;
	}



}
