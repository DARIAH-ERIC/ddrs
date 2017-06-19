---
layout: page
title: DDRS
description: Architecture
---
[Back to DDRS index](index.md)

![alt text](https://github.com/DARIAH-ERIC/ddrs/blob/master/docs/contents/HaS_Logo_klein.png "Humanities at Scale")

## Architecture of the Service
This section describes the technical implementation of the DDRS within the HaS project. One has to differentiate between an ideal concept of the service and the current possible implementation within the project. The latter one has to consider the available resources, the time horizon and the institutional context, e.g. current developments within DARIAH.

#### Workflow for the user
As a reminder: the DDRS initially helps the user to identify suitable research data repositories for the individual case depending on only a few criteria, like formats of the research data, language or affiliation or certain indispensable functions. The result of this step will likely be a ranked list of repositories which can be used by the user as it is. The questions leading to the result list are not mandatory but the result gains quality by answering more questions. After displaying the result list the user can decide to enter the second functionality layer of the DDRS, which is about the structured description of the individual research data. Aim of this step is to gain, as easy and convenient as possible, a structured and coherent data description which serves as basis for initiating the ingest process with the repository. At this stage, the DDRS serves only as communication handler on behalf of the user, pointing his or her ingest request to the appropriate contact person.

#### Architecture overview
The figure below provides an overview of the infrastructure that will be set up within the project. The result is a functional demonstrator, flexible to be developed further on or to be enhanced with additional functionalities. This result serves as proof-of-concept for the idea and will highlight the community’s demand for such a service.

As basic infrastructure for this stage of the DDRS a virtual machine and a domain are sufficient. The VM consists of all necessary applications and will initially be accessible over an IP. At a later stage a conventional URL will be used, likely http://www.ddrs.de.dariah.eu/, and with this blend into the already existing DARIAH infrastructure and services. Nevertheless it is yet to be decided how the specific appearance and branding of the service will look like. It is clear that it is embedded within the DARIAH context, in particular with regard to sustainability, but it seems also preferable to keep the DDRS as “open” as possible. This openness in a sense of an unobtrusive DARIAH branding seems reasonable as the service uses external service providers - such as re3data - and wants to address humanities researchers and the humanities interested audience in a broader way.

![alt text](https://github.com/DARIAH-ERIC/ddrs/blob/master/docs/contents/infrastructure.png "Infrastructure")

The above standing DDRS Infrastructure Model illustrates the basic infrastructure layer and  several components facilitating the use of the DDRS functionalities for the user. The following components are part of this infrastructure:
* A web server hosting the below described components.
* A simple website providing the user with explanatory information on the service, practices for research data in the humanities, further information sources, and displaying the results of the user requests for layer 1 (repository identification) and layer 2 (data description).
* A simple questionnaire of not more than five questions suggesting the user a ranked list of suitable research data repositories for the specific use case. The questionnaire should be designed in such a way that future adjustments of the used questions are possible in an easy way. This is necessary as the used database for the requests - initially re3data - will likely change over time. For example new research funder mandates could be reflected in the metadata and the DDRS has to consider this.
* A web form describing the individual research data in a structured way (can be implemented in a similar way as the questionnaire). The questionnaire above the webform has also to be designed in a flexible way to allow further adjustments on the research data criteria that are to be described by the user. This will likely be the case as the research data practices in the humanities develop and new standards emerge.
* A request API conducting the requests to identify the repositories. The API sends - either filter by filter or all in one - (a) request(s) to the re3data database, allowing to display in the end a list of repositories fulfilling the respective criteria. On the basis of early tests of the re3data API the data quality and performance seem to be sufficient for our purpose and do not seem to trespass on the re3data API’s general performance.
* A database used to enrich the request results from re3data with contact details. This enrichment is necessary as the DDRS not only wants to suggest suitable repositories but wants to point the user to a competent point of contact to facilitate the ingest of the individual research data. Therefore someone with expertise in humanities research data is necessary but this information is not available through the re3data database as this is a non-disciplinary service. The DDRS database also offers the option of further future extensions.
* A forwarding component, basically a mail server. This components mails the completed data description form to the respective repositories.
* A usage statistics component. At this point is not clear what kind of data can be collected by this service. If the DDRS has a considerable user uptake in the future the usage statistics could become a valuable asset to be used for further added value services.

#### TBD
* flowchart of the architecture
* description at which points re3data is included, i.e. metadata schema, retrieval of repositories from their DB
* description of the individual components and their relations