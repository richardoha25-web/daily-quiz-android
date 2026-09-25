# Daily Quiz & Challenge — Native Android Commercial & Monetization Blueprint

## 1. Purpose

This document is the native Android commercial companion to `native-android-roadmap.md`.

It carries forward the V1 commercial/monetization strategy while adapting it to the long-term **educational platform** architecture.

The document defines business/product requirements, monetization concepts, entitlement boundaries, advertising behavior and future commercial architecture. It does not require immediate billing implementation.

## 2. Commercial Product Vision

Daily Quiz & Challenge should become a sustainable educational platform with:
- Useful free learning experiences.
- Advertising-supported free usage.
- Optional Premium subscription.
- Optional one-time Remove Ads purchase.
- Premium content/features.
- Future one-time content packs.
- Future international expansion.
- Centralized entitlement architecture.

Core principle:

> Free users should receive real value. Premium users should receive substantially more value.

The product should not deliberately cripple the free experience simply to force payment.

## 3. Relationship to V2 Platform Architecture

Commercial architecture must work with:
- Native Android navigation.
- Multi-source educational content.
- Question generation and validation.
- Question identity/families/variants.
- Freshness and repetition avoidance.
- Bible content.
- Current Affairs content.
- Future educational sections.
- Account/progress architecture.
- AdMob.

Commercial access must be centralized. Question generators, providers, UI components and individual question records must not independently decide whether a user is entitled to Premium.

Conceptually:

```
Content / Question
      ↓
Access Tier Metadata
      ↓
Central Entitlement Service
      ↓
User Eligibility
      ↓
UI + Content Selection
```

Access-tier metadata is not proof of purchase.

## 4. Revenue Layers

Planned revenue layers:
1. Advertising for free users.
2. Premium subscription.
3. One-time Remove Ads.
4. Premium content/features.
5. Future one-time quiz/content packs.

Optional rewarded ads can remain part of the free experience where appropriate.

The business should not depend on a single revenue source.

## 5. Free Experience

The free tier should provide meaningful value and demonstrate the platform.

Planned free capabilities may include:
- General Knowledge
- Science
- Selected Africa & Nigeria
- Selected Current Affairs
- Selected Bible experiences
- Daily challenges
- Basic results/progress
- Streaks
- Basic quiz modes
- Optional rewarded ads
- Standard advertising-supported usage

The exact free/premium split remains a product decision to be made before commercial enforcement.

Do not create artificial content scarcity merely to manufacture Premium inventory.

## 6. Premium Subscription

Initial subscription concept:
- Monthly Premium
- Yearly Premium

Exact prices are not decided.

Pricing must eventually consider:
- Nigerian and international markets.
- Google Play fees.
- Taxes and applicable requirements.
- Provider/API costs.
- Cloud/backend costs.
- Ad revenue.
- Conversion and retention data.
- Long-term sustainability.

Potential Premium value:
- No ads.
- More quizzes/content.
- Premium categories/topics.
- Advanced quiz modes.
- Expanded Bible experience.
- Advanced Africa & Nigeria content.
- Expanded Current Affairs.
- Advanced statistics.
- Exclusive challenges.
- Enhanced progress/streak features.
- Personalized learning.
- Deeper explanations.
- Future learning tools.

## 7. Remove Ads

A one-time Remove Ads product may be offered.

Remove Ads means:
- Normal advertising is removed.
- Free content remains available.
- It does not automatically unlock the full Premium product.

Important distinction:

**Remove Ads ≠ Premium**

Remove Ads is convenience; Premium is the larger content/feature entitlement.

## 8. Premium Content Model

Commercial access should be modeled separately from provider identity.

Conceptually:

**Category → Topic → Difficulty → Content/Access Tier → Question Source**

Possible future access metadata:
- `FREE`
- `PREMIUM`
- `SPECIAL_PACK`
- `FUTURE_ENTITLEMENT`

These values are content metadata only until centralized entitlement enforcement exists.

Premium questions/content must meet the same factual, freshness, provenance, distractor, clarity and anti-duplication standards as free content.

## 9. Category Commercial Direction

Planning model:

| Area | Possible free layer | Possible premium layer |
|---|---|---|
| General Knowledge | Core quizzes | Advanced modes/content |
| Science | Core quizzes | Advanced modes/content |
| Africa & Nigeria | Selected content | Expanded/deeper content |
| Current Affairs | Daily/selected content | Expanded/advanced content |
| Bible | Selected experience | Full/expanded experience |
| Future sections | To be defined | To be defined |

This is not a locked launch configuration.

## 10. Bible Commercial Architecture

Bible is a major platform section, not simply a quiz category.

Future commercial decisions may apply to:
- Bible reading resources
- Study tools
- Advanced study features
- Expanded quiz experiences
- Licensed premium resources

The underlying Bible content/licensing model must be established before commercial promises are made.

Any translation or copyrighted resource must satisfy licensing requirements.

## 11. Advertising Strategy

V1 AdMob is stabilized and must be preserved as a known-good capability while V2 is implemented.

Planned native strategy:
- Banner in appropriate sections.
- Interstitial at natural transitions.
- Rewarded ad as an explicit optional action.
- Future app-open behavior only if it provides an appropriate user experience.

Rules:
- Ads must not obscure content.
- The core quiz must not become inaccessible because an ad fails.
- Rewarded actions must clearly state the reward.
- Use test ads during development.
- Keep production ad identifiers/configuration separate from development/test configuration.
- Ad behavior must be regression-tested during V2.

V1 has used rewarded bonus behavior and this should remain compatible with the future entitlement architecture.

## 12. Commercial UX Requirements

Premium/store UX should:
- Explain value clearly.
- Show price and billing period clearly.
- Distinguish subscription vs one-time purchase.
- Explain exactly what an entitlement unlocks.
- Avoid deceptive urgency.
- Avoid aggressive paywalls.
- Keep free content useful.
- Provide restore/synchronization behavior.
- Handle pending, failed and expired purchase states clearly.
- Preserve the user's location when returning from a purchase flow.

The Android app should use the supported Google Play purchase flow for digital purchases rather than collecting payment card details directly.

## 13. Entitlement Architecture

Use centralized entitlement state.

Example:

```
User
 ↓
Entitlement state
 ├── premium
 ├── remove_ads
 ├── bible_full
 ├── current_affairs_pro
 ├── advanced_stats
 └── content-pack entitlements
 ↓
Content selection + UI
```

The exact identifiers remain provisional.

The Android UI must consume entitlement state; it should not implement its own independent billing rules.

## 14. Commercial/Data Separation

Keep these concerns separate:

**Content system**
- Facts
- Sources
- Questions
- Families
- Variants
- Validation
- Freshness
- Provenance

**Commercial system**
- Products
- Prices
- Purchases
- Entitlements
- Subscription state

**Android UI**
- Displays availability
- Starts supported purchase flow
- Reflects entitlement state

This separation prevents provider changes or question-system changes from requiring a billing rewrite.

## 15. Future Product Types

The architecture should allow:
- Premium subscriptions
- Remove Ads
- Premium categories
- Premium topic collections
- One-time content packs
- Advanced quiz modes
- Advanced statistics
- Personalized learning
- Future educational products

Possible future access labels must remain metadata contracts until actual enforcement is implemented.

## 16. Infrastructure and Cost Discipline

Commercial architecture should not force paid infrastructure prematurely.

The project remains focused on a zero-cost preparation/development path where practical.

Future infrastructure choices must be justified by actual product requirements, scale, reliability and cost.

Firebase is not required merely because commercial features exist. Authentication, analytics, crash reporting, remote configuration, billing support or other services can be introduced when a concrete requirement is defined.

## 17. Commercial Development Sequence

### Now
- Document commercial requirements.
- Keep access-tier metadata compatible with content models.
- Preserve AdMob.
- Design entitlement boundaries.
- Continue content/provider licensing research.

### Native V2 foundation
- Implement centralized product/access models.
- Keep UI commercial-aware without enforcing purchases.
- Establish account/progress architecture when scheduled.

### Later
- Google Play Billing.
- Premium subscription.
- Remove Ads.
- Premium category/topic access.
- Premium Bible capabilities.
- Current Affairs Pro.
- Content packs.

### Long term
- Personalized learning.
- Challenges/tournaments where appropriate.
- International expansion.
- Additional educational products.

## 18. Decisions Intentionally Not Locked

Do not invent:
- Monthly Premium price.
- Yearly Premium price.
- Remove Ads price.
- Exact free/premium split.
- Exact free quiz limits.
- Exact premium modes.
- Content-pack prices.
- International pricing.
- Final provider mix.
- Final product IDs.
- Final billing implementation.
- Final account/commercial data schema.

These should be decided from validated product, content, provider and market requirements.

## 19. Commercial Success Definition

The commercial system should balance:

**User value + learning quality + retention + sustainable revenue**

A healthy platform should allow:
- Free users to genuinely use the product.
- Ad-supported users to support the service.
- Premium users to receive substantially more value.
- One-time purchase users to have an alternative to subscriptions.
- The business to maintain and expand the platform.
- Commercial architecture to scale without repeated rewrites.

## 20. Relationship to Other V2 Documents

### `native-android-roadmap.md`
Master project roadmap:
- Architecture
- Stages
- Platform direction
- Content/question architecture
- Technical foundation

### `native-android-ui-ux.md`
Product experience blueprint:
- Visual language
- Screens
- Navigation
- Components
- Interaction behavior
- Accessibility
- Native text behavior
- Ads/premium UX

### `native-android-commercial-monetization.md`
Commercial blueprint:
- Free/Premium
- Advertising
- Products
- Entitlements
- Billing
- Commercial architecture

All three must remain synchronized.

## 21. V1 → V2 Commercial Checkpoint — September 25, 2026

V1 is stabilized at the commercial-architecture level.

Confirmed V1 commercial baseline:
- AdMob is the active monetization system.
- Debug builds use test ads.
- Release builds use production AdMob configuration.
- No billing, subscriptions, Premium entitlement enforcement, Remove Ads purchase, or paywall enforcement is implemented in V1.

V2 carries these forward as future capabilities without making them prerequisites for the native shell.

**Current commercial status: V1 stabilized; V2 commercial architecture documented; billing implementation remains future work.**
