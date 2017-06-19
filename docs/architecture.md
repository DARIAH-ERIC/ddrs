---
layout: page
title: DDRS
description: Architecture
---
# Data Deposit Recommendation Service for Research Data Repositories in the Humanities.
## Architecture of the Service

#### Premises
As long as a widely used and established infrastructure for the deposition of research data (as for publications) is not available, a conventional service like a repository registry can be useful in boosting the growth of archived research data. It contributes to lowering the inhibition threshold of the researcher to deposit his data, on the one hand and it may be useful to standardise information on the data repositories as an incentive for interoperable services, on the other hand.

#### Registry for research data repositories with a humanities focus
Technically the service is a registry of suitable deposit services. It catalogues repositories and research data centres and delivers standardised metadata on them, allowing the researcher to decide which repository may be the most qualified one for his case. The collection of the data will initially be done manually but anticipate future automated procedures to harvest data from repositories. It is important to keep in mind that for file-based data repositories will likely be the preferred infrastructure type but for more complex forms of research data – as mentioned above – other infrastructures have to be considered that go beyond conventional repositories.

The registry for deposit infrastructures takes into account the heterogeneity of data and the often compartmentalised research structures in the humanities. Obviously it also takes into account already established services such as re3data.org but functions – as a main distinction – on a discipline-specific level. The service will connect researchers who search for a deposit service on the one hand and the repositories and data centres on the other hand which have a mandate to acquire content and it aims at establishing incentives for both sides to deposit and ingest research data in the humanities.

#### Two tiers: identification of suitable repositories and individual case description
The repository registry and recommender function will initially be implemented on a simple technical level. With progress in coverage and usage, the service will become more sophisticated. The current workflow of the user through the two tiers - repository recommendation and data description/ contact with repository.

The service will guide researchers and research institutions to the most qualified services for their individual depositing concern. What kind of research data can be deposited in which repositories or data centres, what requirements do they have to meet, how does the ingest process work, who can be consulted, what are the costs and necessary service level agreements? These kind of questions will initially be answered only rudimentary as the researcher browses through a catalogue of research data repositories and data centres.

#### Re-using re3data.org
A good visualisation of such a faceted browsing could look like re3data.org has implemented the browsing by subject. The underlying technical solution uses a database with repositories tagged with classifications of the covered content. The user browses through this metadata and gets very quickly results, leading him to the desired repositories.

A similar solution is at hand for HaS. Depending on the detail of the metadata on the repositories that is available various use cases become possible. With a more detailed description of the metadata a more branched inquiry of the researcher’s individual requirements becomes feasible allowing more individually tailored results and thereby improving the user experience. To achieve such a maturity and usefulness in service quality requires one the hand a stable technical solution, on the other hand - and possibly more important - a rich and reliable database.