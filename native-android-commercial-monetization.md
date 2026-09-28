# RichInsights — Native Android V2 Commercial & Monetization Blueprint

## 1. Purpose

This document defines the commercial architecture for **RichInsights** V2.

It is intentionally smaller than the implementation roadmap. It records commercial decisions and boundaries that affect product architecture without pretending that prices, products, or paywalls are already finalized.

## 2. Commercial direction

RichInsights should support a sustainable combination of:
- useful free learning;
- advertising;
- optional Premium;
- optional Remove Ads;
- premium content/features;
- future one-time content packs.

The free experience must remain genuinely useful. Monetization must not require deliberately degrading core learning quality.

## 3. Revenue layers

Planned layers:
1. AdMob advertising for applicable free usage.
2. Premium subscription.
3. One-time Remove Ads.
4. Premium categories/topics/features.
5. Future content packs.

Optional rewarded ads may be used when the reward and user choice are clear.

The exact launch mix is not locked.

## 4. Premium model

Initial concept:
- Monthly Premium
- Yearly Premium

Potential value:
- no ads;
- expanded content;
- premium categories/topics;
- advanced quiz modes;
- expanded Bible experiences;
- advanced statistics;
- personalized learning;
- enhanced explanations;
- exclusive challenges/features.

Exact products, prices, limits, and free/premium boundaries remain undecided until product and cost requirements are validated.

## 5. Remove Ads

Remove Ads is a separate entitlement.

**Remove Ads ≠ Premium**

Remove Ads removes applicable advertising but does not automatically unlock the full Premium product unless a future product decision explicitly combines them.

## 6. Content access tiers

Content may eventually carry access metadata such as:
- `FREE`
- `PREMIUM`
- `SPECIAL_PACK`

These are metadata contracts, not proof of purchase.

Premium content must meet the same factual, validation, provenance, clarity, and anti-duplication standards as free content.

## 7. Central entitlement architecture

Commercial access must be centralized.

Conceptually:

```
Products / Purchases
        ↓
Entitlement state
        ↓
Content selection + UI
```

The Android UI displays entitlement state and starts supported purchase flows. Individual screens, question records, or providers must not implement independent billing rules.

The final entitlement identifiers and backend/account design are not locked.

## 8. Advertising architecture

V2 AdMob is a **fresh implementation**.

Requirements:
- native Google Mobile Ads SDK;
- clear separation of test and production configuration;
- centralized ad management;
- explicit loading/ready/failed states;
- lifecycle-aware behavior;
- graceful failure;
- frequency controls where appropriate;
- no dependency between quiz availability and ad availability.

Planned formats may include:
- banner;
- interstitial;
- rewarded;
- app-open only if justified by the final UX.

Exact placements and frequency rules must be validated during implementation.

## 9. Billing architecture

Future digital purchases should use the supported Google Play purchase flow.

The architecture should allow:
- subscription purchase;
- one-time Remove Ads;
- future content packs;
- restore/synchronization;
- pending purchase states;
- failed purchase states;
- expired/cancelled subscription states;
- entitlement refresh.

Billing is not a prerequisite for the first native shell.

## 10. Commercial/data separation

Keep three concerns separate:

**Content**
- facts;
- sources;
- questions;
- families/variants;
- validation;
- freshness.

**Commercial**
- products;
- purchases;
- prices;
- entitlements.

**Android UI**
- displays availability;
- presents commercial surfaces;
- launches supported purchase flow;
- reflects entitlement state.

This prevents provider/content changes from forcing billing changes.

## 11. Bible and commercial considerations

Bible is a dedicated product area.

Future commercial features may include:
- licensed resources;
- advanced study tools;
- expanded quiz experiences.

No commercial promise should be made for Bible resources until the underlying licensing and distribution rights are confirmed.

## 12. Cost discipline

Do not introduce paid infrastructure merely because Premium or advertising exists.

Future services should be added only for a concrete need such as:
- authentication;
- account sync;
- analytics;
- crash reporting;
- remote configuration;
- billing support;
- content delivery;
- scale/reliability.

Backend/provider choices are still subject to V2 architecture evaluation.

## 13. Development sequence

### Foundation
- define product/access models;
- keep UI commercial-aware without enforcing purchases;
- preserve clean boundaries around advertising.

### Later
- implement AdMob;
- implement Google Play Billing;
- implement entitlement verification;
- introduce Premium/Remove Ads;
- introduce premium content.

### Long term
- content packs;
- personalized learning;
- additional educational products;
- international expansion.

## 14. Deliberately undecided

Do not invent final values for:
- subscription prices;
- Remove Ads price;
- exact free/premium split;
- free quiz limits;
- premium product IDs;
- content-pack prices;
- final provider mix;
- final account/commercial schema.

These are future product/business decisions.

## 15. Relationship to the other V2 documents

### `native-android-roadmap.md`
Master project and implementation roadmap.

### `native-android-ui-ux.md`
Experience, navigation, visual system, screens, interaction, accessibility, and commercial UX.

### This document
Commercial products, advertising, entitlements, billing boundaries, and monetization decisions.

The three documents should remain synchronized, but duplication should be avoided.

## 16. V2 commercial status

- RichInsights is the V2 product identity.
- V2 commercial architecture is planned, not implemented.
- AdMob will be rebuilt natively.
- Billing and Premium are future work.
- Prices and final commercial packaging are intentionally undecided.
